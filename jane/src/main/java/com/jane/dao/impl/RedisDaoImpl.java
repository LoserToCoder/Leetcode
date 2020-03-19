package com.jane.dao.impl;

import com.jane.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
@Repository
public class RedisDaoImpl implements RedisDao {


    @Autowired
    private JedisPool jedisPool;


    @Override
    public boolean exists(String key) {
       Jedis jedis=jedisPool.getResource();
       if(jedis.exists(key)){
           jedis.close();
           return  true;
       }
       return false;
    }

    @Override
    public String get(String key) {
        Jedis jedis=jedisPool.getResource();
        String value=jedis.get(key);
        jedis.close();
        return value;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis=jedisPool.getResource();
        String result=jedis.set(key,value);
        jedis.close();
        return result;
    }

    @Override
    public long expire(String key, int seconds) {
        Jedis jedis=jedisPool.getResource();
        long result=jedis.expire(key,seconds);
        jedis.close();
        return result;
    }

    @Override
    public long del(String key) {
        Jedis jedis=jedisPool.getResource();
        long res = jedis.del(key);
        jedis.close();
        return res;
    }
}
