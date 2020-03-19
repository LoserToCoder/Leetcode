package com.jane.dao.impl;

import com.jane.dao.UserDao;
import com.jane.pojo.Collection;
import com.jane.pojo.Product;
import com.jane.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private QueryRunner queryRunner;
    @Autowired
    private DataSource dataSource;
    @Override
    public User login(String username, String password) throws Exception {
        String sql="select * from user where username=? and password=?";
        User user=queryRunner.query(sql,new BeanHandler<User>(User.class),username,password);
        return user;
    }

    @Override
    public int register(User user) throws Exception {
        String sql="insert into user(username,password,email) values(?,?,?)";
        int nums=queryRunner.update(sql,user.getUsername(),user.getPassword(),user.getEmail());
        return nums;
    }

    @Override
    public int addScore(Integer id) throws Exception {
        String sql="update user set score=score+5 where id=?";
        int nums=queryRunner.update(sql, id);
        return nums;
    }

    @Override
    public Integer validatePassword(String password, Integer id) throws Exception {
        String sql = "select count(*) from user where id=? and password=?";
        Object object=queryRunner.query(sql, new ScalarHandler(1), id, password);
        return object==null?0:Integer.parseInt(object.toString());
    }


    @Override
    public Integer isCollection(String pid,Integer uid) throws Exception {
        String sql = "select count(*) from collections where entityId=? and uid=?";
        Object id=queryRunner.query(sql, new ScalarHandler(1), pid,uid);
        return id==null?0:Integer.parseInt(id.toString());
    }

    @Override
    public Integer cancelCollection(String pid, Integer uid) throws Exception {
        String sql = "delete from collections where uid=? and entityId=?";
        Integer nums=queryRunner.update(sql, uid, pid);
        return nums==null?0:nums;
    }

    @Override
    public List<Collection> collections(Integer id) throws Exception {
        String sql="select * from collections where uid=? limit 0,10";
        List<Collection> collections=queryRunner.query(sql, new BeanListHandler<Collection>(Collection.class), id);
        return collections;
    }

    @Override
    public Integer updateUserEmail(String email, Integer id) throws Exception {
        String sql = "update user set email=? where id=?";
        return queryRunner.update(sql, email, id);
    }

    @Override
    public Integer updateUserPassword(String password, Integer id) throws Exception {
        String sql = "update user set password=? where id=?";
        return queryRunner.update(sql, password, id);
    }

    @Override
    public Integer updateUserInfo(User user) throws Exception {
        String sql = "update user set gender=?,phone=?,address=?,avatar=? where id=?";
        return queryRunner.update(sql,user.getGender(),user.getPhone(),user.getAddress(),user.getAvatar(),user.getId());
    }

    @Override
    public Integer userFocus(Integer uid, Integer focusId) throws Exception {
        String sql = "insert into focus(uid,focusUId) values(?,?)";
        Integer nums = queryRunner.update(sql, uid, focusId);
        return nums==null?0:nums;
    }

    @Override
    public Object validateFocus(Integer uid, Integer focusId) throws Exception {
        String sql="select count(*) from focus where uid=? and focusUId=?";
        Object nums=queryRunner.query(sql, new ScalarHandler(1), uid, focusId);
        return nums;
    }

    @Override
    public List<User> userList() throws Exception {
        String sql = "select * from user";
        List<User>  users=queryRunner.query(sql, new BeanListHandler<User>(User.class));
        return users;
    }

    @Override
    public Integer updateStatus(Integer id, Integer type) throws Exception {
        String sql = "";
        if(type==1){
            sql="update user set `status`=0 where id=?";
        }else{
            sql="update user set `status`=1 where id=?";
        }
        Integer nums=queryRunner.update(sql, id);
        return nums==null?0:nums;
    }

    @Override
    public Integer userScore(Integer uid) throws Exception {
        String sql = "select score from user where id=?";
        Object obj=queryRunner.query(sql, new ScalarHandler(1), uid);
        return obj==null?0:Integer.parseInt(obj.toString());
    }

    @Override
    public Integer scoreConsume(Integer pid, Integer score, Integer uid) throws Exception {
        Connection con=dataSource.getConnection();
        con.setAutoCommit(false);
        try {
            String sql="update product set num=num-1 where id=?";
            String sql2="update user set score=score-? where id=?";
            String sql3 = "insert into score_records(uid,score,productId) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,pid);
            int nums= ps.executeUpdate();
            ps = con.prepareStatement(sql2);
            ps.setInt(1,score);
            ps.setInt(2,uid);
            nums += ps.executeUpdate();
            ps = con.prepareStatement(sql3);
            ps.setInt(1,uid);
            ps.setInt(2,score);
            ps.setInt(3,pid);
            nums+=ps.executeUpdate();
            if(nums==3){
                con.commit();
                return nums;
            }else{
                con.rollback();
                return 0;
            }
        }catch (Exception ex){
          con.rollback();
        }
        return 0;
    }

    @Override
    public List<Product> products(Integer uid) throws Exception {
        String sql = "select * from product where id in (select DISTINCT productId from score_records where uid=?)";
        List<Product> products = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), uid);
        return products;
    }
}
