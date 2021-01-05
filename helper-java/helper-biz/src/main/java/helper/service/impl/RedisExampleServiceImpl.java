package helper.service.impl;

import common.common.properties.RedisKeys;
import common.service.JedisService;
import helper.service.RedisExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisExampleServiceImpl implements RedisExampleService {

    @Autowired
    private JedisService jedisService;

    @Autowired
    private RedisKeys redisKeys;

    @Override
    public String generateDistributeId(String type) {
        return (String) jedisService.evalsha(redisKeys.getDistributeIdShaKey(), 1, type);
    }
}
