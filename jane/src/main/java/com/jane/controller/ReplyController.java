package com.jane.controller;


import com.jane.pojo.Reply;
import com.jane.pojo.Result;
import com.jane.service.ReplyService;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ReplyController {



    @Autowired
    private ReplyService replyService;
    @RequestMapping(value = "/reply/add")
    @ResponseBody
    public Result addReply(Reply reply){
        Result result=new Result();
        try {
            result=replyService.addReply(reply);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            result.setStatus(PageCode.SERVER_ERROR.getCode());
            return result;
        }
    }

    @RequestMapping(value = "/reply/list")
    @ResponseBody
    public Result replyList(Integer commentId){
        Result result=new Result();
        try {
            List<Reply> replies=replyService.replyList(commentId);
            if (replies != null && replies.size() > 0) {
                result.setInfo(replies);
                result.setMsg(PageCode.REPLY_LIST.getMsg());
                result.setStatus(PageCode.REPLY_LIST.getCode());
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(PageCode.SERVER_ERROR.getCode());
            result.setMsg(PageCode.SERVER_ERROR.getMsg());
            return  result;
        }
        result.setMsg(PageCode.REPLY_NO_RESULT.getMsg());
        result.setStatus(PageCode.REPLY_NO_RESULT.getCode());
        return result;
    }



}
