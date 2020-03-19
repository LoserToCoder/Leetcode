package com.jane.service.impl;

import com.jane.dao.RecruitDao;
import com.jane.pojo.Recruit;
import com.jane.service.RecruitService;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecruitServiceImpl implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Override
    public PageBean<Recruit> recruits(Integer pagenums) throws Exception {
        if(pagenums==null||pagenums<1)
            pagenums=1;
        List<Recruit> recruits=recruitDao.recruits(pagenums);
        PageBean<Recruit> beans = new PageBean<>();
        if(recruits!=null&&recruits.size()>0){
            beans.setResults(recruits);
            beans.setResultTotal(recruits.size());
            beans.setCode(PageCode.RECRUIT_DATA.getCode());
            beans.setMsg(PageCode.RECRUIT_DATA.getMsg());
            return beans;
        }
        beans.setCode(PageCode.RECRUIT_NO_RESULTS.getCode());
        beans.setMsg(PageCode.RECRUIT_NO_RESULTS.getMsg());
        return beans;
    }

    @Override
    public Integer incRecruit(Recruit recruit) throws Exception {
        return recruitDao.addRecruit(recruit);
    }

    @Override
    public Integer updateStatus(Integer id) throws Exception {
        if(id!=null)
           return recruitDao.updateRecruitStatus(id);
        return 0;
    }

}
