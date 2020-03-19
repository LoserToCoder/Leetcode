package com.jane.dao;

public interface RedisDao {

    boolean exists(String key);

    String get(String key);

    String set(String key,String value);

    long expire(String key,int seconds);

    long del(String key);



}
