package com.jane.service.impl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jane.dao.CollectionDao;
import com.jane.dao.RedisDao;
import com.jane.dao.UserDao;
import com.jane.pojo.Collection;
import com.jane.pojo.Product;
import com.jane.pojo.Result;
import com.jane.pojo.User;
import com.jane.service.UserService;
import com.jane.utils.PageCode;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private CollectionDao collectionDao;
    @Override
    public Result login(String username, String password,
                        HttpServletRequest request, HttpServletResponse response)throws Exception {
        ObjectMapper mapper=new ObjectMapper();
        Result result=new Result();
        User user=userDao.login(username,password);
        if(user!=null){
            user.setPassword(null);
            String token=UUID.randomUUID().toString().toLowerCase();
            Cookie cookie=new Cookie("T_TOKEN",token);
            cookie.setPath("/");
            cookie.setMaxAge(24*60*60);
            cookie.setDomain("localhost");
            redisDao.set(token,mapper.writeValueAsString(user));
            redisDao.expire(token,1800);
            response.addCookie(cookie);
            result.setStatus(PageCode.LOGIN_SUCCESS.getCode());
            result.setMsg(PageCode.LOGIN_SUCCESS.getMsg());
            return result;
        }
        result.setStatus(PageCode.LOGIN_FAILED.getCode());
        result.setMsg(PageCode.LOGIN_FAILED.getMsg());
        return result;

    }

    @Override
    public Result register(User user) throws Exception {
        int re=userDao.register(user);
        Result result=new Result();
        if(re>0){
            result.setStatus(PageCode.REGISTER_SUCCESS.getCode());
            result.setMsg(PageCode.REGISTER_SUCCESS.getMsg());
            return result;
        }
        result.setStatus(PageCode.REGISTER_FAILED.getCode());
        result.setMsg(PageCode.REGISTER_FAILED.getMsg());
        return result;
    }

    @Override
    public Result getUserInfoByToken(String token)throws Exception{
           if(redisDao.exists(token)){
               ObjectMapper mapper=new ObjectMapper();
               String value=redisDao.get(token);
               redisDao.expire(token,1800);
               User user=mapper.readValue(value, new TypeReference<User>(){});
               Result result=new Result();
               result.setMsg(PageCode.TOKEN_VALID.getMsg());
               result.setStatus(PageCode.TOKEN_VALID.getCode());
               result.setInfo(user);
               return result;
           }
           Result result=new Result();
           result.setMsg(PageCode.TOKEN_INVALID.getMsg());
           result.setStatus(PageCode.TOKEN_INVALID.getCode());
           return result;
    }

    @Override
    public boolean logout(String token) {
        return redisDao.del(token)>0;
    }

    @Override
    public Integer isCollected(String pid,Integer uid) throws Exception {

        return userDao.isCollection(pid,uid);
    }

    @Override
    public Result cancelCollection(String pid, Integer uid) throws Exception {
        Integer nums = userDao.cancelCollection(pid, uid);
        if (nums > 0) {
            Result result=new Result();
            result.setStatus(PageCode.USER_CANCEL_COLLECTION.getCode());
            result.setMsg(PageCode.USER_CANCEL_COLLECTION.getMsg());
            return result;
        }
        return null;
    }


    @Override
    public List<Collection> collections(Integer id) throws Exception {
        return userDao.collections(id);
    }

    @Override
    public Result postCollection(Collection collection) throws Exception {
        Integer nums=collectionDao.collections(collection);
        if(nums>0){
            Result result=new Result();
            result.setMsg(PageCode.POST_COLLECTIONS.getMsg());
            result.setStatus(PageCode.POST_COLLECTIONS.getCode());
            return result;
        }
        Result result=new Result();
        result.setStatus(404);
        result.setMsg("用户收藏失败");
        return result;
    }

    @Override
    public Integer updateUser(User user,String token,Integer type) throws Exception {
        if(type!=null&&type==1){
            return userDao.updateUserEmail(user.getEmail(),user.getId());
        }else if(type!=null&&type==2){
            return userDao.updateUserPassword(user.getPassword(), user.getId());
        } else if (type != null && type == 3) {
            Integer nums=userDao.updateUserInfo(user);
            if (nums != null && nums > 0) {
                ObjectMapper mapper=new ObjectMapper();
                User newUser=mapper.readValue(redisDao.get(token),new TypeReference<User>(){});
                if(newUser!=null){
                    newUser.setAddress(user.getAddress());
                    newUser.setAvatar(user.getAvatar());
                    newUser.setPhone(user.getPhone());
                    newUser.setGender(user.getGender());
                    redisDao.set(token, mapper.writeValueAsString(newUser));
                }
                return nums;
            }
        }
        return null;
    }

    @Override
    public Integer validatePassword(String password, Integer id) throws Exception {
        return userDao.validatePassword(password,id);
    }

    @Override
    public Result userFocus(Integer uid, Integer focusId) throws Exception {
        int nums=userDao.userFocus(uid,focusId);
        Result result=new Result();
        if (nums > 0) {
            result.setStatus(PageCode.USER_FOCUS.getCode());
            result.setMsg(PageCode.USER_FOCUS.getMsg());
            return result;
        }
        result.setMsg(PageCode.USER_FOCUS_FAILED.getMsg());
        result.setStatus(PageCode.USER_FOCUS_FAILED.getCode());
        return result;
    }

    @Override
    public Result validateFocus(Integer uid, Integer focusId) throws Exception {
        Object nums=userDao.validateFocus(uid, focusId);
        Result result=new Result();
        if(nums!=null){
            result.setMsg(PageCode.USER_FOCUSED.getMsg());
            result.setStatus(PageCode.USER_FOCUSED.getCode());
            return result;
        }
        result.setStatus(404);
        result.setMsg("暂未关注此作者");
        return result;
    }

    @Override
    public List<User> getUserList() throws Exception {
        List<User> users = userDao.userList();
        if(users!=null&&users.size()>0)
            return users;
        return null;
    }

    @Override
    public Result updateUserStatus(Integer id, Integer type) throws Exception {
        Integer nums = userDao.updateStatus(id, type);
        if(nums>0){
            Result result=new Result();
            result.setMsg("用户状态处理成功");
            result.setStatus(200);
            return result;
        }
        return null;
    }

    @Override
    public Result userScore(Integer id) throws Exception {
        Integer scores = userDao.userScore(id);
        if(scores>0){
            Result result=new Result();
            result.setStatus(200);
            result.setInfo(scores);
            return result;
        }
        return null;
    }

    @Override
    public Result scoreConsume(Integer pid, Integer score, Integer uid) throws Exception {
        Integer nums=userDao.scoreConsume(pid, score, uid);
        if(nums>0){
            Result result=new Result();
            result.setMsg(PageCode.USER_CONSUME.getMsg());
            result.setStatus(PageCode.USER_CONSUME.getCode());
            return result;
        }
        return null;
    }

    @Override
    public List<Product> scoreProducts(Integer uid) throws Exception {
        List<Product> products=userDao.products(uid);
        if(products!=null&&products.size()>0)
            return products;
        return null;
    }

}
