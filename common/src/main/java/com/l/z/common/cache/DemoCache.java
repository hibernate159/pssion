package com.l.z.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class DemoCache {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void testCache() {
        ValueOperations<String, Object> value = redisTemplate.opsForValue();
        value.get("abc");
    }
}
