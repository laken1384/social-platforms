package com.backend.backend.domin;

import org.springframework.stereotype.Component;

import java.sql.Blob;
import java.sql.Date;

@Component
public class Comments {
    private String CommentID;
    private String UserID;
    private String PostID;
    private String Content;
    private String CreateAt;

    public String getCommentID() {
        return CommentID;
    }

    public void setCommentID(String commentID) {
        CommentID = commentID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPostID() {
        return PostID;
    }

    public void setPostID(String postID) {
        PostID = postID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(String createAt) {
        CreateAt = createAt;
    }
}
