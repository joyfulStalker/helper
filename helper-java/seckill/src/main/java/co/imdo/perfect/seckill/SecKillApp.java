package co.imdo.perfect.seckill;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.zookeeper.ConditionalOnZookeeperEnabled;
import org.springframework.cloud.zookeeper.discovery.ConditionalOnZookeeperDiscoveryEnabled;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuSonglin
 */
@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
@ConditionalOnZookeeperEnabled
@ConditionalOnZookeeperDiscoveryEnabled
public class SecKillApp {

    public static void main(String[] args) {
        try {
            //保存pid
            SpringApplication springApplication = new SpringApplication(SecKillApp.class);
            springApplication.addListeners(new ApplicationPidFileWriter());
            springApplication.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
