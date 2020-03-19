package com.jane.service.impl;

import com.jane.dao.ItemCommonDao;
import com.jane.pojo.Result;
import com.jane.pojo.StarScore;
import com.jane.service.ItemCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCommonServiceImpl implements ItemCommonService {

    @Autowired
    private ItemCommonDao itemCommonDao;
    @Override
    public StarScore itemScore(String pid) throws Exception {
        StarScore score = itemCommonDao.itemScore(pid);
        return score;
    }

    @Override
    public Integer itemAddScore(String pid, Integer uid, Integer score) throws Exception {
        Integer nums=itemCommonDao.itemAddScore(pid, uid, score);
        return nums;
    }

    @Override
    public Object itemUserScore(String pid, Integer uid)throws Exception {
        Object id= itemCommonDao.itemUserScore(pid, uid);
        return id;
    }
}
