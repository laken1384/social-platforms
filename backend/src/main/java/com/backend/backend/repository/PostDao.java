package com.backend.backend.repository;

import com.backend.backend.domin.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //所有貼文
    //個人貼文
    //新增/刪除貼文

    public void addpost(Posts posts){
        String procedureCall = "{CALL addpost(?,?,?,?,?,?)}";
        jdbcTemplate.update(procedureCall, posts.getPostID(), posts.getUserID(), posts.getContent(), posts.getImage(), posts.getCreatedAt(), posts.getTitle());
    }
    public List<Posts> personpost(String token){
        String procedureCall = "{CALL Getpersonpost(?)}";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(procedureCall, token);
        List<Posts> postsList = new ArrayList<Posts>();
        for (Map<String, Object> row : resultList) {
            System.out.println("result = : "+row);
            Posts post = new Posts();
            post.setPostID((String) row.get("PostID"));
            post.setUserID((String) row.get("UserID"));
            post.setContent((String) row.get("Content"));
            post.setImage((Blob) row.get("Image"));
            post.setCreatedAt((String) row.get("CreatedAt"));
            post.setTitle((String) row.get("title"));
            postsList.add(post);
        }
        return postsList;
    }
    public List<Posts> allpost(String token){
        String procedureCall = "SELECT * FROM Posts";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(procedureCall);
        List<Posts> postsList = new ArrayList<Posts>();
        for (Map<String, Object> row : resultList) {
            System.out.println("result = : "+row);

            Posts post = new Posts();
            post.setPostID((String) row.get("PostID"));
            post.setUserID((String) row.get("UserID"));
            post.setContent((String) row.get("Content"));
            post.setImage((Blob) row.get("Image"));
            post.setCreatedAt((String) row.get("CreatedAt"));
            post.setTitle((String) row.get("title"));
            postsList.add(post);
        }
        return postsList;
    }
    public void delpost(String token){
        String procedureCall = "{CALL delpost(?)}";
        jdbcTemplate.update(procedureCall, token);
    }
}
