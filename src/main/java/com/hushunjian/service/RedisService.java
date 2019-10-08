package com.hushunjian.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /*public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }*/
    
    
    //@Autowired
    private JedisPool jedisPool;

    public void set(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key.getBytes(UTF_8), value.getBytes(UTF_8));
        }
    }

    public void set(String key, String value, Integer ttl) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.setex(key.getBytes(UTF_8), ttl, value.getBytes(UTF_8));
        }
    }

    public void set(byte[] key, byte[] value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        }
    }

    public void set(byte[] key, byte[] value, Integer ttl) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.setex(key, ttl, value);
        }
    }

    public String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            byte[] values = jedis.get(key.getBytes(UTF_8));
            log.debug("get key = " + key + ";value = " + new String(values));
            return new String(values);
        }
    }

    public byte[] get(byte[] key) {
        try (Jedis jedis = jedisPool.getResource()) {
            byte[] values = jedis.get(key);
            return values;
        }
    }

    public Long del(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(key.getBytes(UTF_8));
        }
    }

    public Long del(byte[] key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.del(key);
        }
    }

    public Set<String> keys(String pattern) {
        try (Jedis jedis = jedisPool.getResource()) {
            Set<byte[]> values = jedis.keys(pattern.getBytes(UTF_8));
            if (values != null) {
                Set<String> ret = new HashSet<>();
                values.forEach(s -> {
                            ret.add(new String(s));
                            log.debug("get keys values = " + new String(s));
                        }
                );

                return ret;
            }
            return null;
        }
    }

    public Set<byte[]> keys(byte[] pattern) {
        try (Jedis jedis = jedisPool.getResource()) {
            Set<byte[]> values = jedis.keys(pattern);
            return values;
        }
    }

    public void flushDB() {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.flushDB();
        }
    }

    public long dbSize() {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.dbSize();
        }
    }
    
    public boolean exists(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.exists(key.getBytes(UTF_8));
        }
    }
}
