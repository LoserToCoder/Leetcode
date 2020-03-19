package com.jane.service.impl;

import com.jane.dao.PostDao;
import com.jane.dao.RecruitDao;
import com.jane.dao.UserDao;
import com.jane.pojo.*;
import com.jane.service.PostService;
import com.jane.utils.Constants;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;
import org.elasticsearch.rest.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private UserDao userDao;
    @Autowired
    private PostDao postDao;

    @Autowired
    private RecruitDao recruitDao;

    @Override
    public Result compose(Article article) throws Exception {
        Result result=postDao.compose(article);
        if(result.getStatus()==PageCode.ESSAY_CREATE_SUCCESS.getCode())
        {
           int nums=userDao.addScore(article.getId());
           if(nums>0){
               return result;
           }
        }
        return result;
    }

    @Override
    public Result joinCompose(Article article, Integer recruitId) throws Exception {
        Result result=compose(article);
        if(result.getStatus()==PageCode.ESSAY_CREATE_SUCCESS.getCode()){
            int nums=recruitDao.joinRecruit(recruitId, article.getId());
            if(nums>0){
                return result;
            }
        }
        result.setMsg(PageCode.ESSAY_FAILED.getMsg());
        result.setStatus(PageCode.ESSAY_FAILED.getCode());
        return result;
    }

    @Override
    public PageBean<SearchResultCart> search(String keyword,Integer pagenums)throws Exception{
        if(pagenums==null||pagenums<1)
            pagenums=1;
        PageBean<SearchResultCart> bean=postDao.search(keyword,pagenums);
        if(bean.getCode()==200){
            if(bean.getPageTotal()>=1){
                bean.setMsg(PageCode.ESSAY_SUCCESS.getMsg());
                return bean;
            }else{
                bean.setMsg(PageCode.ESSAY_NO_RESULT.getMsg());
                return bean;
            }
        }
        bean.setMsg(PageCode.ESSAY_FAILED.getMsg());
        bean.setCode(PageCode.ESSAY_FAILED.getCode());
        return bean;
    }

    @Override
    public PageBean<SearchResultCart> essayList(Integer pagenums) throws Exception {
        if(pagenums==null||pagenums<1)
            pagenums=1;
        PageBean<SearchResultCart> bean=  postDao.essayList(pagenums);
        if(bean.getCode()==200){
           if(bean.getPageTotal()>0){
               bean.setMsg(PageCode.ESSAY_SUCCESS.getMsg());
               return bean;
           }else{
               bean.setMsg(PageCode.ESSAY_NO_RESULT.getMsg());
               return bean;
           }
        }
        bean.setMsg(PageCode.ESSAY_FAILED.getMsg());
        bean.setCode(PageCode.ESSAY_FAILED.getCode());
        return bean;
    }

    @Override
    public PageBean<SearchResultCart> category(String category, Integer pagenums) throws Exception {
        if(pagenums==null||pagenums<1)
            pagenums=1;
        PageBean<SearchResultCart> bean = postDao.category(category, pagenums);
        if(bean.getCode()==200){
            if(bean.getPageTotal()>=1){
                bean.setMsg(PageCode.ESSAY_SUCCESS.getMsg());
                return bean;
            }else {
                bean.setMsg(PageCode.ESSAY_NO_RESULT.getMsg());
                bean.setCode(PageCode.ESSAY_NO_RESULT.getCode());
                return bean;
            }
        }
        return bean;
    }

    @Override
    public Result essayDetail(String id) throws Exception {
        Result result=new Result();
        Article article=postDao.essayDetail(id);
        if(article!=null){
            result.setMsg(PageCode.ESSAY_DETAIL_SUCCESS.getMsg());
            result.setStatus(PageCode.ESSAY_SUCCESS.getCode());
            result.setInfo(article);
            return result;
        }
        result.setStatus(PageCode.ESSAY_DETAIL_DELETED.getCode());
        result.setMsg(PageCode.ESSAY_DETAIL_DELETED.getMsg());
        return result;
    }

    @Override
    public Result updateViews(String articleId) throws Exception {
        return postDao.updateUV(articleId,Constants.POST_TYPE_VIEWS);
    }

    @Override
    public Result updateLikes(String articleId) throws Exception {
        return postDao.updateUV(articleId,Constants.POST_TYPE_LIKES);
    }

    @Override
    public PageBean<PostRecommend> recommends(Integer pagenums) throws Exception {
        if(pagenums==null||pagenums<1)
            pagenums=1;
        PageBean<PostRecommend> pageBean = postDao.recommends(pagenums);
        return pageBean;
    }

    @Override
    public List<Post> posts(Integer id) throws Exception {
        return postDao.posts(id);
    }
}
