package helper.service.impl;

import common.common.properties.RedisKeys;
import helper.service.RedisExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

@Service
public class RedisExampleServiceImpl implements RedisExampleService {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private RedisKeys redisKeys;

    @Override
    public String generateDistributeId(String type) {
        return (String) jedisPool.getResource().evalsha(redisKeys.getDistributeIdShaKey(), 1, type);
    }
}
