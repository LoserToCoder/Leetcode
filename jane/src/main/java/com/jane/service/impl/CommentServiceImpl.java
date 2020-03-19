package com.jane.service.impl;

import com.jane.dao.CommentDao;
import com.jane.pojo.Comment;
import com.jane.pojo.Result;
import com.jane.service.CommentService;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {



    @Autowired
    private CommentDao commentDao;
    @Override
    public Result addComment(Comment comment) throws Exception {
        Result result=new Result();
        Integer genkey=commentDao.addComment(comment);
        if(genkey!=null){
            comment.setId(genkey);
            result.setInfo(comment);
            result.setStatus(PageCode.COMMENT_ADD_SUCCESS.getCode());
            result.setMsg(PageCode.COMMENT_ADD_SUCCESS.getMsg());
            return result;
        }
        result.setMsg(PageCode.COMMENT_ADD_FAILED.getMsg());
        result.setStatus(PageCode.COMMENT_ADD_FAILED.getCode());
        return result;
    }

    @Override
    public List<Comment> getComments(String id) throws Exception {
        return commentDao.comments(id);
    }
}
