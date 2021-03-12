package co.imdo.perfect.seckill.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;

//
@Slf4j
public class MyCuratorListener implements CuratorListener {

    @Override
    public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
        log.info("======:" + event);
        log.info("======:" + client);
    }
}
