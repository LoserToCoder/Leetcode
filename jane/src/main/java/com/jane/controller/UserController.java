package com.jane.controller;


import com.jane.pojo.Collection;
import com.jane.pojo.Product;
import com.jane.pojo.Result;
import com.jane.pojo.User;
import com.jane.service.UserService;
import com.jane.utils.PageCode;
import org.elasticsearch.index.query.QueryBuilders;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.security.krb5.internal.PAData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpServletRequest request, HttpServletResponse response) {
        Result result = null;
        try {
            result = userService.login(username, password, request, response);
            return result;
        } catch (Exception e) {
            result = new Result();
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            result.setStatus(PageCode.SERVER_ERROR.getCode());
            return result;
        }
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.GET)
    public String login() {
        return "/login/login";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(User user) {
        Result result = null;
        try {
            result = userService.register(user);
            return result;
        } catch (Exception e) {
            result = new Result();
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            result.setStatus(PageCode.SERVER_ERROR.getCode());
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/user/validate", method = RequestMethod.GET)
    public Object validate(String token) {
        try {
            Result result = userService.getUserInfoByToken(token);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Result result = new Result();
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            result.setStatus(PageCode.SERVER_ERROR.getCode());
            return result;
        }
    }


    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String adminHome() {
        return "/admin/index";
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout(String token) {
        boolean isLogOut = userService.logout(token);
        if (isLogOut)
            return "redirect:/login/login.jsp";
        return "redirect:/index";
    }

    @RequestMapping(value = "/user/member", method = RequestMethod.GET)
    public String memeber() {
        return "/user/member";
    }

    @RequestMapping(value = "/user/memberinfo", method = RequestMethod.GET)
    public String memeberinfo() {
        return "/user/member_info";
    }

    @ResponseBody
    @RequestMapping(value = "/user/collection", method = RequestMethod.GET)
    public Result isCollected(String pid, Integer uid) {
        try {
            Integer id = userService.isCollected(pid, uid);
            if (id != null && id > 0) {
                Result result = new Result();
                result.setInfo(id);
                result.setMsg(PageCode.ITEM_COLLECTED.getMsg());
                result.setStatus(PageCode.ITEM_COLLECTED.getCode());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result = new Result();
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/user/cancel/collection", method = RequestMethod.GET)
    public Result cancelCollection(String entityId, Integer uid) {
        try {
            Result result = userService.cancelCollection(entityId, uid);
            if (result != null) {
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result = new Result();
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/user/collections", method = RequestMethod.GET)
    public Result collections(Integer id) {
        boolean isError = false;
        try {
            List<Collection> collections = userService.collections(id);
            if (collections != null && collections.size() > 0) {
                Result result = new Result();
                result.setInfo(collections);
                result.setMsg(PageCode.ITEM_COLLECTIONS.getMsg());
                result.setStatus(PageCode.ITEM_COLLECTIONS.getCode());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            isError = true;
        }
        if (isError) {
            Result result = new Result();
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            result.setStatus(PageCode.SERVER_ERROR.getCode());
            return result;
        }
        Result result = new Result();
        result.setStatus(PageCode.ITEM_COLLECTIONS_NO.getCode());
        result.setMsg(PageCode.ITEM_COLLECTIONS_NO.getMsg());
        return result;

    }

    @ResponseBody
    @RequestMapping(value = "/user/post/collection", method = RequestMethod.GET)
    public Result collection(Collection collection) {
        try {
            Result result = userService.postCollection(collection);
            if (result.getStatus() == PageCode.POST_COLLECTIONS.getCode())
                return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result = new Result();
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        return result;
    }

    @RequestMapping(value = "/user/focus/validate")
    @ResponseBody
    public Result validateFocus(Integer uid, Integer focusId) {
        Result result = null;
        try {
            result = userService.validateFocus(uid, focusId);
            if (result.getStatus() == PageCode.USER_FOCUSED.getCode())
                return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        result = new Result();
        result.setMsg("用户暂未被关注");
        result.setStatus(404);
        return result;
    }

    @RequestMapping(value = "/user/validate/password")
    @ResponseBody
    public Result validatePassword(String password, Integer id) {
        try {
            Integer nums = userService.validatePassword(password, id);
            if (nums != null && nums != 0) {
                Result result = new Result();
                result.setInfo(nums);
                result.setMsg(PageCode.USER_PASSWORD_VALIDATED.getMsg());
                result.setStatus(PageCode.USER_PASSWORD_VALIDATED.getCode());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result = new Result();
        result.setMsg(PageCode.USER_PASSWORD_VALIDATED_FAILED.getMsg());
        result.setStatus(PageCode.USER_PASSWORD_VALIDATED_FAILED.getCode());
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/user/update", method = RequestMethod.GET)
    public Result updateUser(User user, String token, Integer type) {
        try {
            Integer nums = userService.updateUser(user, token, type);
            if (nums != null && nums > 0) {
                Result result = new Result();
                result.setInfo(nums);
                result.setMsg(PageCode.UPDATE_USER.getMsg());
                result.setStatus(PageCode.UPDATE_USER.getCode());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        Result result = new Result();
        result.setStatus(PageCode.UPDATE_USER_FAILED.getCode());
        result.setMsg(PageCode.UPDATE_USER_FAILED.getMsg());
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/user/focus", method = RequestMethod.GET)
    public Result userFocus(Integer uid, Integer focusId) {
        Result result = null;
        try {
            result = userService.userFocus(uid, focusId);
            if (result.getStatus() == PageCode.USER_FOCUS.getCode()) {
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result = new Result();
        result.setStatus(PageCode.USER_FOCUS_FAILED.getCode());
        result.setMsg(PageCode.USER_FOCUS_FAILED.getMsg());
        return result;
    }

    @RequestMapping(value = "/user/list")
    @ResponseBody
    public ModelAndView users(){
        ModelAndView modelAndView=new ModelAndView();
        try {
            List<User> users=userService.getUserList();
            if(users!=null){
                Result result=new Result();
                result.setStatus(PageCode.USER_LIST.getCode());
                result.setMsg(PageCode.USER_LIST.getMsg());
                result.setInfo(users);
                modelAndView.setViewName("/admin/member-list");
                modelAndView.addObject("beans", result);
                return modelAndView;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/error/404");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/user/status", method = RequestMethod.GET)
    public Result updateStatus(Integer id, Integer type) {
        try {
            Result result=userService.updateUserStatus(id, type);
            if(result!=null){
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "/user/scores", method = RequestMethod.GET)
    public Result userScore(Integer uid) {
        try {
            Result result=userService.userScore(uid);
            if(result!=null){
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return result;
    }

    @RequestMapping(value = "/score/consume")
    @ResponseBody
    public Result addProduct(Integer pid, Integer score,Integer uid){
        try {
            Result result=userService.scoreConsume(pid, score, uid);
            if(result!=null){
                return  result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/soft/score")
    public Result scoreProduct(Integer uid){
        try {
            List<Product> products=userService.scoreProducts(uid);
            if(products!=null){
                Result result=new Result();
                result.setMsg(PageCode.PRODUCTS_SCORE.getMsg());
                result.setStatus(PageCode.PRODUCTS_SCORE.getCode());
                result.setInfo(products);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return result;
    }


}
