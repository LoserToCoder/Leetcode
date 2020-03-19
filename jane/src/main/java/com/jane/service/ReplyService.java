package com.jane.service;

import com.jane.pojo.Reply;
import com.jane.pojo.Result;

import java.util.List;

public interface ReplyService {


    Result addReply(Reply reply) throws Exception;

    Result delReply(Integer id) throws Exception;

    List<Reply> replyList(Integer commentId)throws Exception;




}
