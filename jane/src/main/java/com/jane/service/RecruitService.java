package com.jane.service;

import com.jane.pojo.Recruit;
import com.jane.utils.PageBean;
public interface RecruitService {


    PageBean<Recruit> recruits(Integer pagenums)throws Exception;

    Integer incRecruit(Recruit recruit) throws Exception;

    Integer updateStatus(Integer id)throws Exception;

}
