package co.imdo.perfect.vo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "helper")
public class TestVo {
    @Field("_id")
    private String id;

    private String name;
}
