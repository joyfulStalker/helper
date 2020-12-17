package co.imdo.perfect.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ApiModel
@Document("first_mongo")
public class FirstMongo {

    @MongoId
    @ApiModelProperty("id")
    private ObjectId id;

    @ApiModelProperty(value = "name", example = "name")
    private String name;

    @ApiModelProperty(value = "jsonData", example = "name")
    private String jsonData;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "GMT+8")
    @ApiModelProperty(value = "createDate", example = "2020-12-17 15:08:28")
    private String createDate;
}
