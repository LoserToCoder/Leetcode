package com.jane.controller;

import com.jane.pojo.*;
import com.jane.service.PostService;
import com.jane.utils.Constants;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @RequestMapping(value = "/post/update/views")
    @ResponseBody
    public Result updateView(String articleId){
        Result result=null;
        try {
            result=postService.updateViews(articleId);
            if(result.getStatus()==PageCode.ESSAY_UPDATE_VIEW_SUCCESS.getCode())
                return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return  result;
    }
    @RequestMapping(value = "/post/update/likes")
    @ResponseBody
    public Result updateLikes(String articleId){
        try {
            Result result=postService.updateLikes(articleId);
            if (result.getStatus() == PageCode.ESSAY_UPDATE_VIEW_SUCCESS.getCode()) {
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
    @RequestMapping(value = "/post/user")
    @ResponseBody
    public Result posts(Integer id){
        try {
            List<Post> posts=postService.posts(id);
            if (posts != null && posts.size() > 0) {
                Result result=new Result();
                result.setInfo(posts);
                result.setMsg(PageCode.USER_POSTS.getMsg());
                result.setStatus(PageCode.USER_POSTS.getCode());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Result result=new Result();
            result.setStatus(PageCode.SERVER_ERROR.getCode());
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            return result;
        }
        Result result=new Result();
        result.setMsg(PageCode.USER_NO_POST.getMsg());
        result.setStatus(PageCode.USER_NO_POST.getCode());
        return result;

    }
    @ResponseBody
    @RequestMapping(value = "/post/compose")
    public  Object compose(Article article){
        Result result=null;
        try {
            result = postService.compose(article);
            if(result.getStatus()==PageCode.ESSAY_CREATE_SUCCESS.getCode())
                return result;
        } catch (Exception e) {
            e.printStackTrace();

        }
        result.setMsg(PageCode.ESSAY_CREATE_FAILED.getMsg());
        result.setStatus(PageCode.ESSAY_CREATE_FAILED.getCode());
        return result;

    }
    @ResponseBody
    @RequestMapping(value = "/post/recruit/compose")
    public  Object joinRecruit(Article article,Integer recruitId){
        Result result=null;
        try {
            result = postService.joinCompose(article, recruitId);
            if(result.getStatus()==PageCode.ESSAY_CREATE_SUCCESS.getCode())
                return result;
        } catch (Exception e) {
            e.printStackTrace();

        }
        result.setMsg(PageCode.ESSAY_CREATE_FAILED.getMsg());
        result.setStatus(PageCode.ESSAY_CREATE_FAILED.getCode());
        return result;
    }
    @RequestMapping(value ="/search/post/{pagenums}")
    @ResponseBody
    public PageBean<SearchResultCart> search(String keyword,Integer type,@PathVariable Integer pagenums){
        PageBean<SearchResultCart> pageBean=new PageBean<>();
        try {
            if(Constants.PAGEBEAN_POST_TYPE==type){
                pageBean= postService.search(keyword,pagenums);
            }else{
                pageBean = postService.category(keyword, pagenums);
            }
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
            pageBean.setCode(PageCode.ESSAY_FAILED.getCode());
            pageBean.setMsg(PageCode.ESSAY_FAILED.getMsg());
            return  pageBean;
        }
    }
    @RequestMapping(value = "/category/post")
    public ModelAndView categoryPage( @RequestParam String category){
        ModelAndView mv = new ModelAndView();
        try {
            PageBean<SearchResultCart> bean=new PageBean<>();
            bean = postService.category(category, 1);
            mv.setViewName("/essay/essay_list");
            mv.addObject("beans",bean);
            return  mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("/error/404");
            return mv;

        }
    }
    @RequestMapping(value = "/search/post")
    public ModelAndView searchPage( @RequestParam String keyword){
        ModelAndView mv = new ModelAndView();
        try {
            PageBean<SearchResultCart> bean=new PageBean<>();
            bean= postService.search(keyword,1);
            mv.setViewName("/essay/essay_list");
            mv.addObject("beans",bean);
            return  mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("/error/404");
            return mv;

        }
    }
    @RequestMapping(value ="/post/list")
    @ResponseBody
    public ModelAndView essayList(@RequestParam(required = false) Integer pagenum){
        ModelAndView mv=new ModelAndView();
        try {
            PageBean<SearchResultCart> bean=postService.essayList(pagenum);
            mv.addObject("beans",bean);
            mv.setViewName("/essay/essay_list");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("/error/404");
            return mv;
        }
    }
    @RequestMapping(value ="/essay/")
    @ResponseBody
    public ModelAndView essay(@RequestParam(required = false) Integer pagenum){
        ModelAndView mv=new ModelAndView();
        try {
            PageBean<SearchResultCart> bean=postService.essayList(pagenum);
            mv.addObject("beans",bean);
            mv.setViewName("/essay/essay");
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("/error/404");
            return mv;
        }
    }
    @RequestMapping("/post/{id}")
    public ModelAndView essayDetail(@PathVariable String id){
        ModelAndView mv = new ModelAndView();
        try {
            Result result=postService.essayDetail(id);
            if(result.getStatus()==200){
                mv.addObject("post",result);
                mv.setViewName("/essay/essay_detail");
                return mv;
            }else{
                mv.setViewName("/error/404");
                mv.addObject("msg","你所查找的页面已不在");
                return mv;
            }
        } catch (Exception e) {
            e.printStackTrace();
            mv.setViewName("/error/404");
            mv.addObject("msg","你所查找的页面已不在");
            return mv;
        }

    }
    @ResponseBody
    @RequestMapping(value = "/recommend/list/{pagenums}")
    public Object recommends(@PathVariable(required = false) Integer pagenums) {
        try {
            PageBean<PostRecommend> pageBean=postService.recommends(pagenums);
            return pageBean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Result result=new Result();
        result.setStatus(PageCode.ESSAY_FAILED.getCode());
        result.setMsg(PageCode.ESSAY_FAILED.getMsg());
        return result;

    }

}
