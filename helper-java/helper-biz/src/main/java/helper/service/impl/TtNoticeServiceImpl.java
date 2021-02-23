package helper.service.impl;

import cn.hutool.core.bean.BeanUtil;
import co.imdo.perfect.getui.api.GeTuiService;
import co.imdo.perfect.getui.enums.PushBusinessType;
import co.imdo.perfect.getui.po.PushMessageVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.common.base.BaseQuery;
import common.common.base.BizException;
import common.utils.AutoFillBaseDataUtil;
import common.utils.PageUtil;
import helper.entity.TtNotice;
import helper.entity.TtUserDevice;
import helper.mapper.TtNoticeMapper;
import helper.service.ITtNoticeService;
import helper.service.ITtUserDeviceService;
import helper.service.LocalUserService;
import helper.vo.notice.SendNoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息通知  服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2021-02-23
 */
@Service
public class TtNoticeServiceImpl extends ServiceImpl<TtNoticeMapper, TtNotice> implements ITtNoticeService {

    @Autowired
    private GeTuiService geTuiService;

    @Autowired
    private ITtUserDeviceService deviceService;

    @Autowired
    private LocalUserService localUserService;

    @Override
    public void send(SendNoticeVo queryVo) {
        //根据接收者的ID找到cid

        TtUserDevice userDevice = deviceService.getOneByUserId(queryVo.getToUserId());
        if (userDevice == null) {
            throw BizException.BIZ_NOTICE_NO_SUCH_USER;
        }
        PushMessageVo pushMessageVo = new PushMessageVo();
        pushMessageVo.setMessage(queryVo.getContent());
        pushMessageVo.setTitle(queryVo.getTitle());
        pushMessageVo.setType(PushBusinessType.DEFAULT);
        pushMessageVo.setCid(userDevice.getCid());
        geTuiService.push(pushMessageVo);


        TtNotice ttNotice = new TtNotice();
        BeanUtil.copyProperties(queryVo, ttNotice);
        AutoFillBaseDataUtil.fillCreatedData(ttNotice);
        ttNotice.setFromUserId(localUserService.getCurrentUser().getId());
        baseMapper.insert(ttNotice);
    }

    @Override
    public IPage<TtNotice> noticeList(BaseQuery queryVo) {
        LambdaQueryWrapper<TtNotice> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TtNotice::getToUserId, localUserService.getCurrentUser().getId());
        return baseMapper.selectPage(PageUtil.getPage(queryVo), queryWrapper);
    }
}
