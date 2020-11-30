package co.imdo.perfect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuSonglin
 */
@RestController
@SpringBootApplication
public class SentinelApp {

    public static void main(String[] args) {
        try {
            //保存pid
            SpringApplication springApplication = new SpringApplication(SentinelApp.class);
            springApplication.addListeners(new ApplicationPidFileWriter());
            springApplication.run(args);
            //SpringApplication.run(HelperApp.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
