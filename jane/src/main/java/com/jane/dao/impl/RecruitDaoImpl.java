package com.jane.dao.impl;

import com.jane.dao.RecruitDao;
import com.jane.pojo.Recruit;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RecruitDaoImpl implements RecruitDao {

    @Autowired
    private QueryRunner queryRunner;
    @Override
    public List<Recruit> recruits(Integer pagenums) throws Exception {
        String sql = "select id,theme,`desc`,cover,`status`,start_time as startTime,end_time as endTime from recruit order by start_time desc limit ?,?";
        return queryRunner.query(sql,new BeanListHandler<Recruit>(Recruit.class),(pagenums-1)*10,pagenums*10);
    }

    @Override
    public Integer addRecruit(Recruit recruit) throws Exception {
        String sql = "insert into recruit(theme,`desc`,cover,remark,start_time,end_time) values(?,?,?,?,?,?)";
        Integer nums=queryRunner.update(sql, recruit.getTheme(), recruit.getDesc(), recruit.getCover(), recruit.getRemark(), recruit.getStartTime(), recruit.getEndTime());
        return  nums==null?0:nums;
    }

    @Override
    public Integer updateRecruitStatus(Integer id) throws Exception {
        String sql = "update recruit set `status`=2 where id=?";
        Integer nums=queryRunner.update(sql, id);
        return nums==null?0:nums;
    }

    @Override
    public Integer joinRecruit(Integer recruitId, Integer uid) throws Exception {
        String sql = "insert into recruit_records(recruitId,uid) values(?,?)";
        Integer nums = queryRunner.update(sql, recruitId, uid);
        return nums==null?0:nums;
    }


}
