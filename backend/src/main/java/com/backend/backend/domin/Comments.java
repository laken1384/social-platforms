package com.backend.backend.domin;

import org.springframework.stereotype.Component;

import java.sql.Blob;
import java.sql.Date;

@Component
public class Comments {
    private Integer CommentID;
    private Integer UserID;
    private Integer PostID;
    private String Content;
    private Date CreateAt;

    public Integer getCommentID() {
        return CommentID;
    }

    public void setCommentID(Integer commentID) {
        CommentID = commentID;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public Integer getPostID() {
        return PostID;
    }

    public void setPostID(Integer postID) {
        PostID = postID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }
}
