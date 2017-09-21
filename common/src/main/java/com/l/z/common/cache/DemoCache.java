package com.l.z.common.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class DemoCache implements IBaseNameSpace {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void testCache() {
        if (redisTemplate.hasKey(NS_Prefix_Role_Menu_List)) {
            return;
        }
        String[] a = new String[] { "2", "3" };
        ListOperations<String, Object> data = redisTemplate.opsForList();
        data.leftPush(NS_Prefix_Role_Menu_List, a);
    }

    public void testSetCache(String key) {
        BoundSetOperations<String, Object> boundSet = redisTemplate.boundSetOps(key);
        if (!redisTemplate.hasKey(key)) {
            // TODO 生产N个linked
            boundSet.add("");
            boundSet.expire(1, TimeUnit.HOURS);
            return;
        }
        if (boundSet.isMember("")) {
            boundSet.remove("");
        }
        boundSet.size();
        boundSet.members();
    }
}
