package com.jane.service;

import com.jane.pojo.*;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;

import java.util.List;

public interface PostService {

    Result compose(Article article) throws Exception;

    Result joinCompose(Article article,Integer recruitId)throws Exception;

    PageBean<SearchResultCart> search(String keyword,Integer pagenums) throws Exception;

    PageBean<SearchResultCart> essayList(Integer pagenums) throws Exception;

    PageBean<SearchResultCart> category(String category, Integer pagenums)throws Exception;

    Result essayDetail(String id) throws Exception;

    Result updateViews(String articleId)throws Exception;

    Result updateLikes(String articleId)throws Exception;

    PageBean<PostRecommend> recommends(Integer pagenums)throws Exception;

    List<Post> posts(Integer id)throws Exception;
}
