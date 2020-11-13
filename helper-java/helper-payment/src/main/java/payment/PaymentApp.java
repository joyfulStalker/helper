package payment;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan(basePackages = "payment.mapper")
public class PaymentApp {

    public static void main(String[] args) {
        try {
            //保存pid
            SpringApplication springApplication = new SpringApplication(PaymentApp.class);
            springApplication.addListeners(new ApplicationPidFileWriter());
            springApplication.run(args);
            //SpringApplication.run(HelperApp.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
