package com.jane.service;

import com.jane.pojo.Comment;
import com.jane.pojo.Result;

import java.util.List;

public interface CommentService {

    Result addComment(Comment comment) throws Exception;

    List<Comment> getComments(String id)throws Exception;


}
