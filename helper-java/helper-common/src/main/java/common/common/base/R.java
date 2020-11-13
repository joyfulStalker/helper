package common.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author liuSongLin
 * @Description 统一返回格式
 * @Date 21:38 2019/6/9
 * @Param
 * @return
 **/
@Data
@ApiModel("响应基础类")
public class R<T> {

    public R() {
    }

    public R(T t) {
        this.code = BaseCode.SUCCESS;
        this.msg = "";
        this.data = t;
    }

    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(Integer code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.data = t;
    }

    @ApiModelProperty("响应码")
    protected Integer code;

    @ApiModelProperty("错误信息")
    protected String msg;

    @ApiModelProperty("耗费时间")
    protected long takeTimeMillis;

    @ApiModelProperty("响应数据")
    private T data;

    public static <T> R<T> of(Integer code, String msg, T t) {
        return new R<>(code, msg, t);
    }

    public static <T> R<T> of(Integer code, String msg) {
        return new R<>(code, msg);
    }

    public static <T> R<T> of(T t) {
        return new R<>(BaseCode.SUCCESS, "ok", t);
    }

    public static R of() {
        return new R(BaseCode.SUCCESS, "ok");
    }
}
