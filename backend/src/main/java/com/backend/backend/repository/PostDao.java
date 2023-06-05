package com.backend.backend.repository;

import com.backend.backend.domin.Comment.Comment_compoent;
import com.backend.backend.domin.Comment.PostComment;
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
    public List<PostComment> personpost(String token){
        String procedureCall = "{CALL Getpersonpost(?)}";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(procedureCall, token);
        List<PostComment> postsList = new ArrayList<PostComment>();
        for (Map<String, Object> row : resultList) {
            System.out.println("result = : "+row);

            String proCall = "CALL GetComment(?)";
            List<Map<String, Object>> comments = jdbcTemplate.queryForList(proCall, (String) row.get("PostID"));

            PostComment post = new PostComment();
//            PostComment.setPostID((String) row.get("PostID"));
            post.setTitle((String) row.get("title"));
            post.setContext((String) row.get("Content"));
            post.setUsername((String) row.get("UserName"));
            post.setCreatedAt((String) row.get("CreatedAt"));
            post.setPostID((String) row.get("PostID"));
            List<Comment_compoent> commentList = new ArrayList<Comment_compoent>();

            for (Map<String, Object> cell : comments) {
                Comment_compoent comment = new Comment_compoent();
                System.out.println("cell = : " + cell);
                comment.setUserName((String) cell.get("UserName"));
                comment.setComments((String) cell.get("Content"));
                commentList.add(comment);
            }
            post.setComment(commentList);
            postsList.add(post);
        }
        return postsList;
    }
    public List<PostComment> allpost(String token){
        String procedureCall = "CALL GetAllPost()";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(procedureCall);
        List<PostComment> postsList = new ArrayList<PostComment>();
        for (Map<String, Object> row : resultList) {
            System.out.println("result = : "+row);

            String proCall = "CALL GetComment(?)";
            List<Map<String, Object>> comments = jdbcTemplate.queryForList(proCall, (String) row.get("PostID"));

            PostComment post = new PostComment();
//            PostComment.setPostID((String) row.get("PostID"));
            post.setTitle((String) row.get("title"));
            post.setContext((String) row.get("Content"));
            post.setUsername((String) row.get("UserName"));
            post.setCreatedAt((String) row.get("CreatedAt"));
            post.setPostID((String) row.get("PostID"));
            List<Comment_compoent> commentList = new ArrayList<Comment_compoent>();

            for (Map<String, Object> cell : comments) {
                Comment_compoent comment = new Comment_compoent();
                System.out.println("cell = : " + cell);
                comment.setUserName((String) cell.get("UserName"));
                comment.setComments((String) cell.get("Content"));
                commentList.add(comment);
            }
            post.setComment(commentList);
            postsList.add(post);
        }
        return postsList;
    }
    public void delpost(String token){
        String procedureCall = "{CALL delpost(?)}";
        jdbcTemplate.update(procedureCall, token);
    }
}
