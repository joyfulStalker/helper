package rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuSonglin
 */
@Slf4j
@RestController
@SpringBootApplication
public class RabbitMQApp {

    public static void main(String[] args) {
        try {
            //保存pid
            SpringApplication springApplication = new SpringApplication(RabbitMQApp.class);
            springApplication.addListeners(new ApplicationPidFileWriter());
            springApplication.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
