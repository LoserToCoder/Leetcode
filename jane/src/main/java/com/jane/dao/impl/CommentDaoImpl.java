package com.jane.dao.impl;

import com.jane.dao.CommentDao;
import com.jane.pojo.Comment;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private QueryRunner queryRunner;

    @Override
    public Integer addComment(Comment comment) throws Exception {

        Connection connection = null;
        try {
            connection=dataSource.getConnection();
            String sql="insert into comments(uid,entityId,content,commentTime,commentType) values(?,?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1,comment.getUid());
            ps.setString(2,comment.getEntityId());
            ps.setString(3,comment.getContent());
            ps.setString(4,comment.getCommentTime());
            ps.setInt(5,comment.getCommentType());
            if(ps.executeUpdate()>0){
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next())
                   return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(connection!=null){
                connection.close();
            }
        }
        return null;
    }

    @Override
    public Integer deleteComment(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Comment> comments(String id) throws Exception {
        String sql = "select c.id,c.content,c.commentTime,c.entityId,u.id as uid,u.username from comments as c inner join user as u on u.id=c.uid where c.entityId=?";
        List<Comment> comments=queryRunner.query(sql, new BeanListHandler<Comment>(Comment.class), id);
        return comments;
    }
}
