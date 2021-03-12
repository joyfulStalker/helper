package co.imdo.perfect.seckill.web;


import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("zookeeper")
public class ZookeeperController {

    @Autowired
    private CuratorFramework curatorFramework;

    @GetMapping("set")
    private String set() throws Exception {
        Stat stat = curatorFramework.setData().forPath("/f", "hhh".getBytes());

        return "ok";
    }

    @GetMapping("get")
    private String get() throws Exception {
        return new String(curatorFramework.getData().watched().forPath("/f"));
    }
}
