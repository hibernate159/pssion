package com.l.z.common.cache;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.l.z.common.utils.StringUtil;

public class CsrfTokenCache implements IBaseNameSpace {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public boolean tokenCheck(String userId, String token) {
        if (StringUtils.isBlank(token)) {
            return false;
        }
        BoundSetOperations<String, String> boundSet = redisTemplate.boundSetOps(NS_Prefix_Csrf_Toke + userId);
        initTokens(boundSet);
        if (boundSet.isMember(token)) {
            boundSet.remove(token);
            return true;
        }
        return false;
    }

    public Set<String> tokenMembers(String userId) {
        BoundSetOperations<String, String> boundSet = redisTemplate.boundSetOps(NS_Prefix_Csrf_Toke + userId);
        initTokens(boundSet);
        return boundSet.distinctRandomMembers(3);
    }

    private void initTokens(BoundSetOperations<String, String> boundSet) {
        if (boundSet.size() < 3) {
            boundSet.add(getTokenValue(), getTokenValue());
            boundSet.expire(1, TimeUnit.DAYS);
        }
    }

    private String getTokenValue() {
        long seed = new Random().nextLong();
        return StringUtil.longToString(seed) + StringUtil.longToString(System.nanoTime());
    }

}
