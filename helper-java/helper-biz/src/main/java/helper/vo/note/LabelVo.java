package helper.vo.note;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("标签")
public class LabelVo {


    private Integer labelId;

    /**
     * 标签名称
     */
    private String labelName;

    /**
     * 业务类型(1. 消息提醒 2.任务性质 3.笔记标签)
     */
    private Integer businessType;

}
