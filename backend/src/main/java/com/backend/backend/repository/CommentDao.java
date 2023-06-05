package com.backend.backend.repository;

import com.backend.backend.domin.Comments;
import com.backend.backend.domin.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addcomment(Comments comments){
        String procedureCall = "{CALL addcomment(?,?,?,?)}";
        jdbcTemplate.update(procedureCall, comments.getCommentID(), comments.getPostID(), comments.getUserID(), comments.getContent());
    }
}
