package com.jane.dao.impl;

import com.jane.dao.ProductDao;
import com.jane.pojo.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private QueryRunner queryRunner;
    @Override
    public List<Product> selectAllProduct() throws Exception {
        String sql="select id,title,score,picture,num from product order by score";
        List<Product> list=queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
        return list;
    }

    @Override
    public Integer productDel(Integer id) throws Exception {
        String sql = "delete from product where id=?";
        Integer nums=queryRunner.update(sql, id);
        return nums==null?0:nums;
    }

    @Override
    public Integer addProduct(Product product) throws Exception {
        String sql="insert into product(title,score,picture,num) values(?,?,?,?)";
        Integer nums=queryRunner.update(sql, product.getTitle(), product.getScore(), product.getPicture(), product.getNum());
        return nums==null?0:nums;
    }
}
