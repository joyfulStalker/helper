package co.imdo.perfect.seckill.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

//
@Slf4j
@Configuration
public class ZookeeperConfig {

    @Autowired
    private CuratorFramework curatorFramework;

    /**
     * Curator Apache
     * 供的个访问Zookeeper的工具包，封装了这些低级别操作同时也提供一些高级服务，比如分布式锁、领导选取
     *
     * @return
     */
    @PostConstruct
    public void curatorFramework() {
        // ExponentialBackoffRetry是种重连策略，每次重连的间隔会越来越长,1000毫秒是初始化的间隔时间,3代表尝试重连次数。
//        ExponentialBackoffRetry retry = new ExponentialBackoffRetry(1000, 3);
//        // 创建client
//        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("xxx.xxx.xxx.xxx:2181", retry);
        // 添加watched 监听器
        curatorFramework.getCuratorListenable().addListener(new MyCuratorListener());
    }

}
