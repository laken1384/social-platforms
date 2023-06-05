package com.backend.backend.domin.Comment;

import java.util.ArrayList;
import java.util.List;

public class PostComment {
    private String Title;
    private String CreatedAt;
    private String Username;
    private String Context;
    private String PostID;
    private List<Comment_compoent> Comment;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public String getPostID() {
        return PostID;
    }

    public void setPostID(String postID) {
        PostID = postID;
    }

    public List<Comment_compoent> getComment() {
        return Comment;
    }

    public void setComment(List<Comment_compoent> comment) {
        Comment = comment;
    }
}
