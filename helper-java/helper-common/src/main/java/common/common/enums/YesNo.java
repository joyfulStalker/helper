package common.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liuSongLin
 */

@Getter
@AllArgsConstructor
public enum YesNo {

    /**
     * 真、是
     */
    YES(1),
    /**
     * 假、否
     */
    NO(0),
    ;

    private Integer value;
}
