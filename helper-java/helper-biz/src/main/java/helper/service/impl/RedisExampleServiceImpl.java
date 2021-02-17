package helper.service.impl;

import co.imdo.perfect.properties.RedisShaKeys;
import co.imdo.perfect.service.JedisService;
import helper.service.RedisExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisExampleServiceImpl implements RedisExampleService {

    @Autowired
    private JedisService jedisService;

    @Autowired
    private RedisShaKeys redisKeys;

    @Override
    public String generateDistributeId(String type) {
        return (String) jedisService.evalsha(redisKeys.getDistributedId(), 1, type);
    }
}
