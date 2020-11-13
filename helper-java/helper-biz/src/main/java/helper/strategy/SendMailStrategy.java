package helper.strategy;

import common.common.enums.RequestEnum;
import common.utils.SpringTool;
import helper.service.MailTemplateService;
import helper.vo.mail.MailBean;
import lombok.extern.slf4j.Slf4j;

/**
 * 发送邮件策略
 *
 * @author liuSonglin
 */
@Slf4j
public class SendMailStrategy implements SendStrategy {

    @Override
    public void send(String requester, String randomCode) {
        //从容器中获取bean
        MailTemplateService mailTemplateService = (MailTemplateService) SpringTool.getBean("mailTemplateService");
        log.info("发送到邮箱：" + requester + "的验证码是" + randomCode + "！");
        MailBean mailBean = new MailBean();
        mailBean.setRecipient(requester);
        mailBean.setSubject("验证码");
        mailBean.setContent("尊敬的用户，验证码为：" + randomCode + "。如果不是本人操作，请忽略本邮件。");
        mailTemplateService.sendSimpleMail(mailBean);
        log.info("发送到邮箱：" + requester + "成功结束");
    }

    @Override
    public RequestEnum getSendType() {
        return RequestEnum.MAIL;
    }
}
