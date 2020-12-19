package co.imdo.perfect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolAbstract;

@RestController
@RequestMapping("/redis")
public class TestSentinelController {

    @Autowired
    private JedisPoolAbstract jedisPool;

    @ResponseBody
    @GetMapping("/get")
    public String test1(@RequestParam("name") String name) {
        Jedis jedis = jedisPool.getResource();
        String s = jedis.get(name);
        jedis.close();
        return s;
    }
}
