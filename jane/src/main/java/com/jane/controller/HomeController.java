package com.jane.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @RequestMapping("/essay/list")
    public ModelAndView index(){
        System.out.println("首页跳转中...");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/essay/essay_list");
        return mv;
    }
    @RequestMapping(value = "/index")
    public String home(){
        return "/index";
    }

    @RequestMapping(value = "/post/pub/{id}")
    public ModelAndView  pub(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/post/publish");
        mv.addObject("id",id);
        return mv;
    }


}
