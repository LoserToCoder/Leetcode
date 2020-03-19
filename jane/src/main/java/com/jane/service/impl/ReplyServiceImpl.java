package com.jane.service.impl;

import com.jane.dao.ReplyDao;
import com.jane.pojo.Reply;
import com.jane.pojo.Result;
import com.jane.service.ReplyService;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    @Override
    public Result addReply(Reply reply) throws Exception {
          Integer genkey=replyDao.addReply(reply);
          Result result=new Result();
          if(genkey!=null){
              reply.setId(genkey);
              result.setInfo(reply);
              result.setMsg(PageCode.REPLY_ADD_SUCCESS.getMsg());
              result.setStatus(PageCode.REPLY_ADD_SUCCESS.getCode());
              return result;
          }
          result.setMsg(PageCode.REPLY_ADD_FAILED.getMsg());
          result.setStatus(PageCode.REPLY_ADD_FAILED.getCode());
          return result;
    }
    @Override
    public Result delReply(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Reply> replyList(Integer commentId) throws Exception {
        return replyDao.getReplyLists(commentId);
    }
}
