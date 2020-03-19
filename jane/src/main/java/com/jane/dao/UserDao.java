package com.jane.dao;

import com.jane.pojo.Collection;
import com.jane.pojo.Product;
import com.jane.pojo.User;

import java.util.List;

public interface UserDao {

    User login(String username,String password) throws Exception;

    int register(User user) throws  Exception;

    int addScore(Integer id)throws Exception;

    Integer validatePassword(String password,Integer id) throws Exception;

    Integer isCollection(String pid,Integer uid)throws Exception;

    Integer cancelCollection(String pid,Integer uid)throws Exception;
    List<Collection> collections(Integer id)throws Exception;

    Integer updateUserEmail(String email,Integer id) throws Exception;

    Integer updateUserPassword(String password,Integer id) throws Exception;

    Integer updateUserInfo(User user)throws Exception;

    Integer userFocus(Integer uid,Integer focusId)throws Exception;

    Object validateFocus(Integer uid, Integer focusId)throws Exception;

    List<User> userList()throws Exception;

    Integer updateStatus(Integer id,Integer type)throws Exception;

    Integer userScore(Integer uid)throws Exception;

    Integer scoreConsume(Integer pid, Integer score, Integer uid)throws Exception;

    List<Product> products(Integer uid)throws Exception;
}
