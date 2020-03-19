package com.jane.dao;

import com.jane.pojo.Reply;

import java.util.List;

public interface ReplyDao {


    Integer addReply(Reply reply) throws Exception;


    Integer deleteReply(Integer id) throws Exception;


    List<Reply> getReplyLists(Integer commentId) throws Exception;

}
