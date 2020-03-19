package com.jane.dao.impl;

import com.jane.dao.ItemCommonDao;
import com.jane.pojo.StarScore;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemCommonDaoImpl implements ItemCommonDao {

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public StarScore itemScore(String pid) throws Exception {
        String sql = "select count(*) as counts,avg(score) as average from item_score where pid=?";
        StarScore starScore=queryRunner.query(sql, new BeanHandler<StarScore>(StarScore.class), pid);
        return starScore;
    }

    @Override
    public Integer itemAddScore(String pid, Integer uid,Integer score) throws Exception {
        String sql="insert into item_score(pid,uid,score) values(?,?,?)";
        Integer nums=queryRunner.update(sql, pid, uid, score);
        return nums;
    }

    @Override
    public Object itemUserScore(String pid, Integer uid) throws Exception{
        String sql="select id from item_score where pid=? and uid=?";
        Object id=queryRunner.query(sql, new ScalarHandler(1), pid, uid);
        return id;
    }
}
