package com.jane.service;

import com.jane.pojo.Result;
import com.jane.pojo.StarScore;

public interface  ItemCommonService {
    StarScore itemScore(String pid)throws Exception;

    Integer itemAddScore(String pid, Integer uid, Integer score)throws Exception;

    Object itemUserScore(String pid, Integer uid)throws Exception;
}
