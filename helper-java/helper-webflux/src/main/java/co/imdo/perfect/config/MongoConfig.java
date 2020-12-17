package co.imdo.perfect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MongoConfig {

    @Bean("reactiveMongoTemplate")
    public ReactiveMongoTemplate getReactiveMongoTemplate(ReactiveMongoDatabaseFactory databaseFactory, MappingMongoConverter mongoConverter) {
        //去除查询条件带_class的问题
        mongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new ReactiveMongoTemplate(databaseFactory, mongoConverter);
    }
}
