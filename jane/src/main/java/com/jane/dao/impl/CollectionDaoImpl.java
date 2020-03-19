package com.jane.dao.impl;

import com.jane.dao.CollectionDao;
import com.jane.pojo.Collection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CollectionDaoImpl implements CollectionDao {

    @Autowired
    private QueryRunner queryRunner;
    @Override
    public int collections(Collection collection) throws Exception {
        String sql = "insert into collections(entityId,title,type,uid) values(?,?,?,?)";
        int nums=queryRunner.update(sql,collection.getEntityId(),collection.getTitle(),collection.getType(),collection.getUid());
        return nums;
    }
}
