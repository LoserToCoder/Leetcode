package com.jane.controller;


import com.jane.pojo.Result;
import com.jane.service.CategoryService;
import com.jane.service.impl.CategoryServiceImpl;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonsController {


    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/post/category")
    @ResponseBody
    public Result getCategory(@RequestParam(required = false) Integer cid){
        Result result=null;
        try {
            result=categoryService.getAllCategorys(cid);
            if(result.getStatus()==PageCode.CATEGORY_SUCCESS.getCode())
                return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        result=new Result();
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        return result;
    }



}
