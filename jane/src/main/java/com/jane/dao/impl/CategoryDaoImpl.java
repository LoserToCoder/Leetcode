package com.jane.dao.impl;

import com.jane.dao.CategoryDao;
import com.jane.pojo.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public List<Category> selectAllCategory() throws Exception {
        String sql="select category_id as cid,name,pinyin from item_category where is_parent=0";
        List<Category> categories=queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
        return categories;
    }

    @Override
    public List<Category> selectAllSubCategory(Integer cid) throws Exception {
        String sql="select category_id as cid,name,pinyin from item_category where parent_id=?";
        List<Category> categories=queryRunner.query(sql,new BeanListHandler<Category>(Category.class),cid);
        return categories;
    }
}
