package com.jane.dao.impl;


import com.jane.dao.ReplyDao;
import com.jane.pojo.Reply;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Repository
public class ReplyDaoImpl implements ReplyDao {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public Integer addReply(Reply reply) throws Exception {
        Connection connection=null;
        try {
            connection=dataSource.getConnection();
            String sql = "insert into reply(replyContent,commentId,replyTime,uid,parentId) values(?,?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,reply.getReplyContent());
            ps.setInt(2,reply.getCommentId());
            ps.setString(3,reply.getReplyTime());
            ps.setInt(4,reply.getUid());
            ps.setInt(5,reply.getParentId());
            if(ps.executeUpdate()>0){
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next())
                    return rs.getInt(1);
            }
        }finally {
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }



    @Override
    public Integer deleteReply(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Reply> getReplyLists(Integer commentId) throws Exception {
        String sql = "select r.id, r.commentId,r.replyContent,r.replyTime,r.parentId,u.username,u.id as uid from reply as r inner join user as u on r.uid=u.id where r.commentId=?";
        List<Reply> replyList = queryRunner.query(sql, new BeanListHandler<Reply>(Reply.class), commentId);
        return replyList;
    }
}
