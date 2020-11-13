package helper.vo.mail;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuSonglin
 */
@Data
public class MailBean implements Serializable {

    /**
     * 邮件接收人
     */
    private String recipient;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;

}