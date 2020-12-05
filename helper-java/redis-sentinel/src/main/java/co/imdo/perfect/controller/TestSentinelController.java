package co.imdo.perfect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolAbstract;

@RestController
@RequestMapping("/sentinel")
public class TestSentinelController {

    @Autowired
    private JedisPoolAbstract jedisPool;

    @Autowired
    private ValueOperations opsForValue;

    @ResponseBody
    @GetMapping("/test1")
    public String test1(@RequestParam("name") String name) {
        Jedis jedis = jedisPool.getResource();
        String s = jedis.get(name);
        jedis.close();
        return s;
    }

    @ResponseBody
    @GetMapping("/temp")
    public String redisTemplate(@RequestParam("name") String name) {
        Object o = opsForValue.get(name);
        return o.toString();
    }
}
