package helper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 车主信息表
 * </p>
 *
 * @author liuSongLin
 * @since 2020-08-18
 */
@Data
@TableName("payment_car_owner")
public class PaymentCarOwner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 姓名/公司名称
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    /**
     * 车牌号
     */
    private String license;
    /**
     * 密码
     */
    private String password;
}
