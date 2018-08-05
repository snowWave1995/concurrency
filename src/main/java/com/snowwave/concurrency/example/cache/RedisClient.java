package com.snowwave.concurrency.example.cache;

import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * Created by zhangfuqiang on 2018/8/5.
 */
@Component
public class RedisClient {

    @Resource(name = "redisPool")
    private JedisPool jedisPool;

}
