package com.jane.controller;


import com.jane.pojo.Comment;
import com.jane.pojo.Result;
import com.jane.service.CommentService;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;
    @RequestMapping(value = "/comment/add")
    @ResponseBody
    public Result addComment(Comment comment){

        Result result=new Result();
        try {
            result=commentService.addComment(comment);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            result.setStatus(PageCode.SERVER_ERROR.getCode());
            return result;
        }
    }

    @RequestMapping(value = "/post/comments")
    @ResponseBody
    public Result getComments(String id){

        Result result=new Result();
        try {
            List<Comment> comments=commentService.getComments(id);
            if(comments!=null&&comments.size()>0){
                result.setStatus(PageCode.COMMENT_LOAD_SUCCESS.getCode());
                result.setMsg(PageCode.COMMENT_LOAD_SUCCESS.getMsg());
                result.setInfo(comments);
                return  result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            result.setStatus(PageCode.SERVER_ERROR.getCode());
            return result;
        }
        result.setMsg(PageCode.COMMENT_NO_RESULT.getMsg());
        result.setStatus(PageCode.COMMENT_NO_RESULT.getCode());
        return result;
    }





}
