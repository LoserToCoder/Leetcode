package com.jane.controller;


import com.jane.pojo.ItemSearchCart;
import com.jane.service.ItemService;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/search")
public class ItemSearchController {


    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item")
    public ModelAndView searchItem(@RequestParam String keyword,@RequestParam(required = false) Integer pagenums){
        ModelAndView modelAndView = new ModelAndView();
        try {
            PageBean<ItemSearchCart>pageBean=itemService.search(keyword,pagenums);
            if(pageBean.getCode()==PageCode.ITEM_SEARCH_SUCCESS.getCode()){
                modelAndView.setViewName("/item/shop");
                modelAndView.addObject("beans",pageBean);
                return modelAndView;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/error/404");
        return modelAndView;
    }
    @RequestMapping(value = "/scene")
    public ModelAndView searchScene(@RequestParam String keyword,@RequestParam(required = false) Integer pagesnum){
        ModelAndView mv=new ModelAndView();
        try {
            PageBean<ItemSearchCart> pageBean=itemService.searchByScene(keyword,pagesnum);
            if(pageBean.getCode()==PageCode.ITEM_SEARCH_SUCCESS.getCode()){
                mv.setViewName("/item/shop");
                mv.addObject("beans",pageBean);
                return mv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("/error/404");
        return mv;
    }

    @RequestMapping(value = "/category")
    public ModelAndView searchCategory(@RequestParam String category,@RequestParam(required = false) Integer pagesnum){
        ModelAndView modelAndView = new ModelAndView();
        try {
            PageBean<ItemSearchCart> pageBean=itemService.searchCategory(category,pagesnum);
            if(pageBean.getCode()==PageCode.ITEM_SEARCH_SUCCESS.getCode()){
                modelAndView.setViewName("/item/shop");
                modelAndView.addObject("beans", pageBean);
                return modelAndView;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/error/404");
        return modelAndView;
    }

    @RequestMapping(value = "/asyn")
    @ResponseBody
    public PageBean<ItemSearchCart> asynSearch(@RequestParam String keyword,@RequestParam(required = false) Integer pagenums) {
        PageBean<ItemSearchCart> pageBean = new PageBean<>();
        try {
            pageBean = itemService.search(keyword, pagenums);
            if (pageBean.getCode() == PageCode.ITEM_SEARCH_SUCCESS.getCode()) {
                if (pageBean.getResultTotal() >= 1) {
                    pageBean.setMsg(PageCode.ITEM_SEARCH_SUCCESS.getMsg());
                    return pageBean;
                }
                pageBean.setCode(PageCode.ITEM_SEARCH_NO_RESULT.getCode());
                pageBean.setMsg(PageCode.ITEM_SEARCH_NO_RESULT.getMsg());
                return pageBean;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        pageBean.setCode(PageCode.SERVER_ERROR.getCode());
        pageBean.setMsg(PageCode.SERVER_ERROR.getMsg());
        return pageBean;
    }

    @RequestMapping(value = "/filter")
    public ModelAndView filterSearch(@RequestParam(required = false) String keyword,@RequestParam Double minPrice,@RequestParam Double maxPrice,@RequestParam(required = false) Integer pagenums){
        ModelAndView modelAndView = new ModelAndView();
        try {
            PageBean<ItemSearchCart> pageBean = itemService.filterSearch(keyword, minPrice, maxPrice, pagenums);
            if(pageBean.getCode()==PageCode.ITEM_SEARCH_SUCCESS.getCode()){
                modelAndView.setViewName("/item/shop");
                modelAndView.addObject("beans",pageBean);
                return modelAndView;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/error/404");
        return modelAndView;
    }
}
