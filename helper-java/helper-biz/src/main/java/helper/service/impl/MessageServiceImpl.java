package helper.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.common.base.BizException;
import common.common.enums.RequestEnum;
import common.common.enums.SmsEnum;
import common.common.enums.YesNo;
import common.utils.AutoFillBaseDataUtil;
import common.utils.ClientIpUtils;
import common.utils.RandomCodeUtil;
import helper.entity.Message;
import helper.factory.SendStrategyFactory;
import helper.mapper.MessageMapper;
import helper.service.IMessageService;
import helper.strategy.SendStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

import static common.common.Constant.EXECUTOR_SERVICE;

/**
 * <p>
 * 短信发送  服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

    @Override
    public void sendCode(RequestEnum requestEnum, String requester, SmsEnum smsEnum, HttpServletRequest request) {
        Message message = getMessageByMobileAndBusinessType(requestEnum, requester, smsEnum);
        if (message != null) {
            // 与当前时间对比
            if ((message.getSendTime().getTime() + message.getEffectiveDuration().longValue() * 60 * 1000) > System.currentTimeMillis()) {
                //未过期
                throw BizException.BIZ_MSG_RESEND_EXCEPTION;
            } else {
                //先逻辑删除上一个
                deleteCode(message);
                insertMessageAndSendCodeToUser(requestEnum, requester, smsEnum, request);
            }
        } else {
            insertMessageAndSendCodeToUser(requestEnum, requester, smsEnum, request);
        }
    }


    @Override
    public void checkCode(RequestEnum requestEnum, String requester, SmsEnum smsEnum) {
        Message message = getMessageByMobileAndBusinessType(requestEnum, requester, smsEnum);
        if (message == null) {
            throw BizException.BIZ_MSG_CODE_FALSE_EXCEPTION;
        }
        if (message.getSendTime().getTime() + message.getEffectiveDuration().longValue() * 60 > System.currentTimeMillis()) {
            //未过期
            throw BizException.BIZ_MSG_RESEND_EXCEPTION;
        }
        //删除该验证码
        deleteCode(message);
    }

    @Override
    public void deleteCode(Message message) {
        LambdaUpdateWrapper<Message> updateWrapper = new LambdaUpdateWrapper<>();
        AutoFillBaseDataUtil.fillUpdatedData(message);
        updateWrapper.set(Message::getIsDelete, YesNo.YES.getValue());
        baseMapper.update(message, updateWrapper);
    }


    /**
     * 根据手机号和业务类型获取信息
     *
     * @param requestEnum  请求者类型
     * @param requester    请求者
     * @param businessType 业务类型
     * @return 响应
     */
    private Message getMessageByMobileAndBusinessType(RequestEnum requestEnum, String requester, SmsEnum businessType) {
        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Message::getRequestType, requestEnum.getValue());
        queryWrapper.eq(Message::getRequester, requester);
        queryWrapper.eq(Message::getBusinessType, businessType.getBusinessType());
        return baseMapper.selectOne(queryWrapper);
    }


    /**
     * 保存验证码 并发送到用户
     *
     * @param requestEnum
     * @param requester
     * @param smsEnum
     */
    private void insertMessageAndSendCodeToUser(RequestEnum requestEnum, String requester, SmsEnum smsEnum, HttpServletRequest request) {
        Message message = new Message();
        //生成一个验证码
        String randomCode = RandomCodeUtil.randomCode();
        AutoFillBaseDataUtil.fillCreatedData(message);
        message.setBusinessType(smsEnum.getBusinessType());
        message.setRequestType(requestEnum.getValue());
        // 有效时长
        message.setEffectiveDuration(5);
        message.setRequester(requester);
        message.setVerificationCode(randomCode);
        message.setSendIp(ClientIpUtils.getClientIp(request));
        baseMapper.insert(message);
        //发送验证码
        sendMsgToUser(requestEnum, requester, randomCode);
    }

    /**
     * 异步发送
     *
     * @param requestEnum
     * @param requester
     * @param randomCode
     */
    private void sendMsgToUser(RequestEnum requestEnum, String requester, String randomCode) {
        EXECUTOR_SERVICE.execute(() -> {
            SendStrategy sendStrategy = SendStrategyFactory.getInstance().getSendStrategy(requestEnum);
            sendStrategy.send(requester, randomCode);
        });
    }

}
