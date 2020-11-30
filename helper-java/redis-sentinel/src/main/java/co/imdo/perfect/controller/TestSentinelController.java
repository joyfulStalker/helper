package co.imdo.perfect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolAbstract;

@RestController
@RequestMapping("/sentinel")
public class TestSentinelController {

    @Autowired
    private JedisPoolAbstract jedisPool;

    @ResponseBody
    @PostMapping("/test1")
    public String test1() {
        Jedis jedis = jedisPool.getResource();
        return jedis.get("a");
    }
}
