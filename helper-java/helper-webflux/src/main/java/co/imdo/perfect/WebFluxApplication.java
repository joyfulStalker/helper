package co.imdo.perfect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author lsl
 */
@EnableWebFlux
@SpringBootApplication
@EnableReactiveMongoRepositories(basePackages = "co.imdo.perfect.repository")
public class WebFluxApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(WebFluxApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}