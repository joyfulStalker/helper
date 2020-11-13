package common.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 任务调度相关的枚举
 *
 * @author liusonglin
 * @date 2018年11月22日
 */
@Getter
@AllArgsConstructor
public enum JobStatusEnum {

    /**
     * 0:停止
     */
    STOP("0", "停止"),
    /**
     * 1:运行
     */
    RUNNING("1", "运行");
    /**
     * 成员变量 值
     */
    private String val;
    /**
     * 对应描述
     */
    private String desc;

}
