package com.jane.dao;

import com.jane.pojo.*;
import com.jane.utils.PageBean;

import java.util.List;

public interface PostDao {


    Result compose(Article article) throws  Exception;

    PageBean<SearchResultCart> search(String keyword,int pagenums) throws  Exception;
    PageBean<SearchResultCart> essayList(int pagenum) throws  Exception;
    PageBean<SearchResultCart> category(String category,int pagenums) throws Exception;
    Article essayDetail(String id) throws  Exception;
    Result updateUV(String articleId,Integer types)throws Exception;


    PageBean<PostRecommend> recommends(Integer pagenums)throws Exception;
    List<Post> posts(Integer id)throws Exception;

}
