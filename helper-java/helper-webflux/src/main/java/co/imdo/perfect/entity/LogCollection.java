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

    @ApiModelProperty(value = "level", example = "level")
    private String level;

    @ApiModelProperty(value = "logger", example = "logger")
    private String logger;

    @ApiModelProperty(value = "thread", example = "thread")
    private String thread;

    @ApiModelProperty(value = "message", example = "message")
    private String message;
}
