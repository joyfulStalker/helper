//package co.imdo.perfect.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
//import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
//import org.springframework.data.mongodb.core.convert.MongoConverter;
//
//@Configuration
//public class MongoConfig {
//
//    @Bean
//    public DefaultMongoTypeMapper getDefaultMongoTypeMapper(){
//        return new DefaultMongoTypeMapper(null);
//    }
//
//
//    @Bean
//    public ReactiveMongoTemplate getReactiveMongoTemplate(ReactiveMongoDatabaseFactory databaseFactory){
//        MongoConverter mongoConverter = new MappingMongoConverter();
//
//    }
//}
