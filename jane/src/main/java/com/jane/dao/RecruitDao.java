package com.jane.dao;

import com.jane.pojo.Recruit;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface RecruitDao {


    List<Recruit> recruits(Integer pagenums)throws Exception;

    Integer addRecruit(Recruit recruit) throws Exception;

    Integer updateRecruitStatus(Integer id) throws Exception;

    Integer joinRecruit(Integer recruitId, Integer uid)throws Exception;

}
