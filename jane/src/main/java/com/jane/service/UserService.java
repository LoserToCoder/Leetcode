package com.jane.service;

import com.jane.pojo.Collection;
import com.jane.pojo.Product;
import com.jane.pojo.Result;
import com.jane.pojo.User;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {

    Result login(String username, String password,
                 HttpServletRequest request, HttpServletResponse response)throws Exception;
    Result register(User user) throws  Exception;

    Result getUserInfoByToken(String token)throws Exception;

    boolean logout(String token);

    Integer isCollected(String pid,Integer uid) throws Exception;

    Result cancelCollection(String pid,Integer uid)throws Exception;

    List<Collection> collections(Integer id)throws Exception;

    Result postCollection(Collection collection)throws Exception;

    Integer updateUser(User user,String token, Integer type) throws Exception;

    Integer validatePassword(String password, Integer id)throws Exception;

    Result userFocus(Integer uid, Integer focusId)throws Exception;

    Result validateFocus(Integer uid,Integer focusId) throws Exception;

    List<User> getUserList()throws Exception;

    Result updateUserStatus(Integer id, Integer type)throws Exception;
    Result userScore(Integer id)throws Exception;

    Result scoreConsume(Integer pid, Integer score, Integer uid)throws Exception;

    List<Product> scoreProducts(Integer uid)throws Exception;
}
