package com.jane.service.impl;

import com.jane.dao.CategoryDao;
import com.jane.pojo.Category;
import com.jane.pojo.Result;
import com.jane.service.CategoryService;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {



    @Autowired
    private CategoryDao categoryDao;

    public Result getAllCategorys(Integer cid) throws  Exception{
        Result result=new Result();
        List<Category>categories=null;
        if(cid!=null){
            categories=categoryDao.selectAllSubCategory(cid);
        }else{
            categories=categoryDao.selectAllCategory();
        }
        if(categories!=null){
            result.setStatus(PageCode.CATEGORY_SUCCESS.getCode());
            result.setMsg(PageCode.CATEGORY_SUCCESS.getMsg());
            result.setInfo(categories);
            return result;
        }
        result.setStatus(PageCode.CATEGORY_FAILED.getCode());
        result.setMsg(PageCode.CATEGORY_FAILED.getMsg());
        return  result;
    }





}
