package helper.service;

import helper.vo.mail.MailBean;

/**
 * @author liuSonglin
 */
public interface MailTemplateService {


    /**
     * 发送一个简单格式的邮件
     *
     * @param mailBean
     */
    void sendSimpleMail(MailBean mailBean);


    /**
     * 发送一个HTML格式的邮件
     *
     * @param mailBean
     */
    void sendHtmlMail(MailBean mailBean);

    /**
     * 发送带附件格式的邮件
     *
     * @param mailBean
     */
    void sendAttachmentMail(MailBean mailBean);

    /**
     * 发送带静态资源的邮件
     *
     * @param mailBean
     */
    void sendInlineMail(MailBean mailBean);

    /**
     * 发送基于Freemarker模板的邮件
     *
     * @param mailBean
     */
    void sendTemplateMail(MailBean mailBean);
}
