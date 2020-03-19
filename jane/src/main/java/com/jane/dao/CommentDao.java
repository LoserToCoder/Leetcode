package com.jane.dao;

import com.jane.pojo.Comment;
import com.jane.pojo.Result;

import java.util.List;

public interface CommentDao {


    Integer addComment(Comment comment) throws Exception;

    Integer deleteComment(Integer id)throws Exception;

    List<Comment> comments(String id)throws Exception;

}
