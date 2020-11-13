package helper.vo.more;

import lombok.Data;

import java.util.Date;

/**
 * @author liuSonglin
 */
@Data
public class MenstruationRemindDTO {
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 昵称
     */
    private String userNick;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 是否疼痛
     */
    private Boolean isAche;

}
