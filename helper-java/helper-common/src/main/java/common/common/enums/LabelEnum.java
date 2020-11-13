package common.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 针对标签与业务关联表设计枚举
 */
@Getter
@AllArgsConstructor
public enum LabelEnum {

    NOTE(3, "tt_note");

    /**
     * 业务类型
     */
    private Integer businessType;
    /**
     * 对应的业务主表
     */
    private String businessTable;
}
