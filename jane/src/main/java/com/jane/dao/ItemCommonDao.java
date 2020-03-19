package com.jane.dao;

import com.jane.pojo.StarScore;

public interface ItemCommonDao {


   StarScore itemScore(String pid) throws Exception;

   Integer itemAddScore(String pid,Integer uid,Integer score) throws Exception;

    Object itemUserScore(String pid, Integer uid) throws Exception;
}
