package com.jane.controller;


import com.jane.pojo.Product;
import com.jane.pojo.Result;
import com.jane.service.ProductService;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ScoreController {


    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/score/shop")
    public ModelAndView scoreShop(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/shop/shop");
        try {
            PageBean<Product> beans=productService.queryAllProduct();
            modelAndView.addObject("beans",beans);
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("/error/404");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/products/list")
    public ModelAndView adminProduct(){
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<Product> products = productService.getProductList();
            if(products!=null){
                modelAndView.setViewName("/admin/product-list");
                modelAndView.addObject("beans",products);
                return modelAndView;
            }
        } catch (Exception e) {

        }
        modelAndView.setViewName("/error/404");
        return modelAndView;
    }

    @RequestMapping(value = "/product/del")
    @ResponseBody
    public Result delProduct(Integer pid) {
        try {
            Result result=productService.delProduct(pid);
            if(result!=null)
                return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return result;
    }
    @RequestMapping(value = "/product/add")
    @ResponseBody
    public Result addProduct(Product product){
        try {
            Result result=productService.addProduct(product);
            if(result!=null){
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result= new Result();
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        return result;
    }



}
