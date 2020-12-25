package co.imdo.perfect.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@ApiModel
@Document(collection = "log_collection")
public class LogCollection {
    @MongoId(targetType = FieldType.OBJECT_ID)
    @ApiModelProperty("id")
    private String id;

    private String level;
    private String logger;
    private String thread;
    private String interfaceMsg;
    private String causeBy;
    private String occurTime;
    private Object detailMsg;
    private String ste;
}
