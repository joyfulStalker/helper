package common.config;

import common.common.base.BaseCode;
import common.common.base.BizException;
import common.common.base.R;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Desc 全局异常处理
 * @Author liuSongLin
 * @Date 2019/6/2 11:33
 * @Version 1.0v
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * @return lsl.mint.helper_test.common.base.BaseResponse
     * @Author liuSongLin
     * @Description 捕获业务异常
     * @Date 21:44 2019/6/9
     * @Param [response, e]
     **/
    @ExceptionHandler({BizException.class})
    public R bizExceptionHandler(HttpServletResponse response, BizException e) {
        e.printStackTrace();
        return new R(e.getCode(), e.getMsg());
    }

    /**
     * 校验异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public R bodyValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        e.printStackTrace();
        return new R(BaseCode.CHECK_FAILED, fieldErrors.get(0).getDefaultMessage());
    }

    /**
     * @return java.lang.String
     * @Author liuSongLin
     * @Description 全局异常
     * @Date 11:37 2019/6/2
     * @Param [response, ex]
     **/
    @ExceptionHandler(Exception.class)
    public R baseExceptionHandler(HttpServletResponse response, Exception e) {
        e.printStackTrace();
        return new R(BaseCode.ERROR_UNKNOWN, "系统错误！");
    }

}