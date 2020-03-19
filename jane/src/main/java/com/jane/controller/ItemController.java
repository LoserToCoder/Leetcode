package com.jane.controller;


import com.jane.pojo.*;
import com.jane.service.ItemService;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.security.krb5.internal.PAData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ItemController {

    @Autowired

    private ItemService itemService;

    @RequestMapping("/item/add")
    @ResponseBody
    public Object add(HttpServletRequest request){
        Result result=null;

        String title=request.getParameter("title");
        try {
            result=itemService.add(request);
            return  result;
        } catch (Exception e) {
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            result.setStatus(PageCode.SERVER_ERROR.getCode());
        }
        return result;
    }

    @RequestMapping("/item/{id}.html")
    public ModelAndView itemDetail(@PathVariable String id) {
        ModelAndView modelAndView=new ModelAndView();
        try {
            Item item=itemService.itemDetail(id);
           if(item!=null){
               modelAndView.setViewName("/item/shop_detail");
               modelAndView.addObject("item",item);
               return modelAndView;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/error/404");
        return modelAndView;
    }


    @RequestMapping("/pub/item/{id}")
    public ModelAndView pubSHop(@PathVariable Integer id) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("bean", id);
        modelAndView.setViewName("/post/publish_shop");
        return modelAndView;
    }


    @RequestMapping(value = "/item/update")
    @ResponseBody
    public Result updateViews(String pid,String type){
        try {
           return itemService.update(pid,type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        return result;
    }
    @RequestMapping(value = "/item/collection")
    @ResponseBody
    public Result updateViews(Collection collection){
        try {
            return itemService.update(collection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        return result;
    }
    @RequestMapping(value = "/item/recommends")
    @ResponseBody
    public Result recommends(String category){
        try {
            List<Recommend> recommends=itemService.recommends(category);
            if(recommends!=null){
                Result result=new Result();
                result.setMsg(PageCode.ITEM_RECOMMENDS.getMsg());
                result.setStatus(PageCode.ITEM_RECOMMENDS.getCode());
                result.setInfo(recommends);
                return  result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        return  result;
    }
    @RequestMapping(value = "/user/item")
    @ResponseBody
    public Result items(Integer id){
        Result result=null;
        try {
            List<ItemPost> items=itemService.items(id);
            if(items!=null&&items.size()>0){
                result=new Result();
                result.setInfo(items);
                result.setMsg(PageCode.USER_ITEMS.getMsg());
                result.setStatus(PageCode.USER_ITEMS.getCode());
                return  result;
            }
            result=new Result();
            result.setMsg(PageCode.USER_NO_ITEM.getMsg());
            result.setStatus(PageCode.USER_NO_ITEM.getCode());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result=new Result();
            result.setStatus(PageCode.SERVER_ERROR.getCode());
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            return result;
        }

    }

}
