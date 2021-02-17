package helper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户设备表
 * </p>
 *
 * @author liuSongLin
 * @since 2021-02-17
 */
@Data
@TableName("tt_user_device")
public class TtUserDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private Integer userid;

    /**
     * 个推cid
     */
    private String cid;


}
