package com.jane.controller;


import com.jane.pojo.Recruit;
import com.jane.pojo.Result;
import com.jane.service.RecruitService;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RecruitController {


    @Autowired
    private RecruitService recruitService;

    @RequestMapping(value = "/recruit/list")
    public ModelAndView recruitList(@RequestParam(required = false) Integer pagenums){
        ModelAndView modelAndView=new ModelAndView();
        try {
           PageBean<Recruit> beans = recruitService.recruits(pagenums);
            if (beans.getCode() == PageCode.RECRUIT_DATA.getCode()) {
                modelAndView.addObject("beans", beans);
                modelAndView.setViewName("/admin/recruit-list");
                return modelAndView;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/error/404");
        return  modelAndView;
    }
    @RequestMapping(value = "/recruit/events")
    public ModelAndView recruits(@RequestParam(required = false) Integer pagenums){
        ModelAndView modelAndView=new ModelAndView();
        try {
            PageBean<Recruit> beans = recruitService.recruits(pagenums);
            if (beans.getCode() == PageCode.RECRUIT_DATA.getCode()) {
                modelAndView.addObject("beans", beans);
                modelAndView.setViewName("/events/recruit");
                return modelAndView;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("/error/404");
        return  modelAndView;
    }

    @RequestMapping(value = "/recruit/add")
    @ResponseBody
    public Result addRecruit(Recruit recruit) {
        try {
           Integer num=recruitService.incRecruit(recruit);
           if(num>0){
               Result result=new Result();
               result.setInfo(num);
               result.setMsg(PageCode.RECRUIT_ADD_SUCCESS.getMsg());
               result.setStatus(PageCode.RECRUIT_ADD_FAILED.getCode());
               return result;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setMsg(PageCode.RECRUIT_ADD_FAILED.getMsg());
        result.setStatus(PageCode.RECRUIT_ADD_FAILED.getCode());
        return result;
    }

    @RequestMapping(value = "/recruit/deadline")
    @ResponseBody
    public Result updateRecruitStatus(Integer id) {
        try {
            Integer nums=recruitService.updateStatus(id);
            if(nums>0){
                Result result=new Result();
                result.setMsg(PageCode.RECRUIT_UPDATE_SUCCESS.getMsg());
                result.setStatus(PageCode.RECRUIT_UPDATE_SUCCESS.getCode());
                return result;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setMsg(PageCode.RECRUIT_UPDATE_FAILED.getMsg());
        result.setStatus(PageCode.RECRUIT_UPDATE_FAILED.getCode());
        return result;
    }

    @RequestMapping(value = "/recruit/join")
    public ModelAndView joinRecruit(Integer recruitId,Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recruitId", recruitId);
        modelAndView.addObject("id", id);
        modelAndView.setViewName("/post/post_recruit");
        return modelAndView;
    }



}
