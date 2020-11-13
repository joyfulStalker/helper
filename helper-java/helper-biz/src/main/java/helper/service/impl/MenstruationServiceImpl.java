package helper.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.common.base.BizException;
import common.utils.AutoFillBaseDataUtil;
import common.utils.PageUtil;
import helper.entity.Menstruation;
import helper.mapper.MenstruationMapper;
import helper.service.IMenstruationService;
import helper.service.MailTemplateService;
import helper.vo.mail.MailBean;
import helper.vo.more.MenstruationQueryVO;
import helper.vo.more.MenstruationRemindDTO;
import helper.vo.more.MenstruationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static common.common.Constant.EXECUTOR_SERVICE;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class MenstruationServiceImpl extends ServiceImpl<MenstruationMapper, Menstruation> implements IMenstruationService {

    @Autowired
    private MailTemplateService mailTemplateService;

    @Override
    public void addOrUpdate(MenstruationVO menstruationVo) {
        if (menstruationVo.getEndDate() != null) {
            if (DateUtil.compare(menstruationVo.getStartDate(), menstruationVo.getEndDate()) >= 0) {
                throw BizException.BIZ_MENSTRUATION_DATE_ERR_EXCEPTION;
            }
        }

        Menstruation menstruation = new Menstruation();
        if (menstruationVo.getId() == null) {
            BeanUtil.copyProperties(menstruationVo, menstruation);
            log.info("新增");
            AutoFillBaseDataUtil.fillCreatedData(menstruation);
            menstruation.setUserId(1);
            baseMapper.insert(menstruation);
        } else {
            log.info("修改");
            menstruation = baseMapper.selectById(menstruationVo.getId());
            if (menstruation == null) {
                throw BizException.BIZ_MENSTRUATION_NOT_EXIST_EXCEPTION;
            }
            BeanUtil.copyProperties(menstruationVo, menstruation);
            AutoFillBaseDataUtil.fillUpdatedData(menstruation);
            baseMapper.updateById(menstruation);
        }
    }

    @Override
    public IPage<Menstruation> list(MenstruationQueryVO queryVO) {
        return baseMapper.list(PageUtil.getPage(queryVO), queryVO);
    }

    @Override
    public void taskMenstruationRemind() {
        log.info("定时任务：taskMenstruationRemind开始");
        List<MenstruationRemindDTO> list = baseMapper.taskRemind();
        if (CollectionUtil.isEmpty(list)) {
            log.info("没有查到数据，结束");
            return;
        }
        Map<Integer, List<MenstruationRemindDTO>> maps = list.stream().collect(Collectors.groupingBy(MenstruationRemindDTO::getUserId));
        for (Integer key : maps.keySet()) {
            EXECUTOR_SERVICE.execute(() -> analysisAndRemind(maps.get(key)));
        }
    }

    /**
     * 多线程异步发送
     *
     * @param menstruationReminds
     */
    private void analysisAndRemind(List<MenstruationRemindDTO> menstruationReminds) {
        //现根据时间排序
        menstruationReminds = menstruationReminds.stream().sorted(Comparator.comparing(MenstruationRemindDTO::getStartDate)).collect(Collectors.toList());
        MenstruationRemindDTO first = menstruationReminds.get(0);
        MenstruationRemindDTO last = menstruationReminds.get(menstruationReminds.size() - 1);
        //分析数据
        StringBuilder sb = new StringBuilder();
        sb.append("历史统计：\n");
        sb.append("&ensp;&ensp;&ensp;&ensp;数据统计从" + DateUtil.format(first.getStartDate(), "yyyy-MM-dd") + "开始，至" + DateUtil.format(last.getStartDate(), "yyyy-MM-dd") + "结束，共计" + menstruationReminds.size() + "次。");
        sb.append("其中痛经" + menstruationReminds.stream().filter(e -> e.getIsAche()).count() + "次。");
        sb.append("\n上次大姨妈：\n");
        sb.append("&ensp;&ensp;&ensp;&ensp;时间是：" + DateUtil.format(last.getStartDate(), "yyyy-MM-dd") + ",结束时间是：" + DateUtil.format(last.getEndDate(), "yyyy-MM-dd") + "。");
        if (last.getIsAche()) {
            sb.append("期间出现了疼痛，这次注意提前喝药哦！");
        }
        sb.append("\n预测：\n");
        if (menstruationReminds.size() == 1) {
            sb.append("&ensp;&ensp;&ensp;&ensp;下一次大姨妈驾临时间预计是:" + DateUtil.offsetDay(first.getStartDate(), 28).toString("yyyy-MM-dd"))
                    .append("持续时间4天,记得提前准备哦！！");
            if (DateUtil.compare(new Date(), DateUtil.offsetDay(last.getStartDate(), 22)) == -1) {
                log.info("没到时间不提醒");
                return;
            }
        } else {
            Long avgIntervalTime = 0L;
            Long continuedTime = 0L;
            int times = 0;
            for (int i = 1; i < menstruationReminds.size(); i++) {
                avgIntervalTime += DateUtil.betweenDay(menstruationReminds.get(i).getStartDate(), menstruationReminds.get(i - 1).getStartDate(), true);
                if (menstruationReminds.get(i - 1).getEndDate() != null) {
                    continuedTime += DateUtil.betweenDay(menstruationReminds.get(i - 1).getStartDate(), menstruationReminds.get(i - 1).getEndDate(), true);
                    times++;
                }
            }
            log.info(avgIntervalTime + "--" + (menstruationReminds.size() - 1) + "");
            sb.append("&ensp;&ensp;&ensp;&ensp;下一次大姨妈驾临时间预计是: " + DateUtil.offsetDay(last.getStartDate(), (int) (avgIntervalTime / (menstruationReminds.size() - 1))).toString("yyyy-MM-dd"))
                    .append("持续时间" + BigDecimal.valueOf(continuedTime).divide(BigDecimal.valueOf(times), 2, BigDecimal.ROUND_HALF_UP) + "天,记得提前准备哦！！");

            if (DateUtil.compare(new Date(), DateUtil.offsetDay(last.getStartDate(), (int) ((avgIntervalTime / (menstruationReminds.size() - 1)) - 6))) == -1) {
                log.info("没到时间不提醒");
                return;
            }

        }
        MailBean mailBean = new MailBean();
        mailBean.setContent(sb.toString());
        mailBean.setRecipient(first.getMail());
        mailBean.setSubject("大姨妈提醒");
        mailTemplateService.sendSimpleMail(mailBean);
        log.info("大姨妈提醒邮箱发送结束！");
    }
}
