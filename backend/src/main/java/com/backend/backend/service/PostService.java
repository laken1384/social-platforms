package com.backend.backend.service;

import com.backend.backend.domin.Comment.PostComment;
import com.backend.backend.domin.Posts;
import com.backend.backend.repository.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostDao postDao;
    public void addposts(Posts posts){
        postDao.addpost(posts);
    }
    public List<PostComment> personposts(String token){
        return postDao.personpost(token);
    }
    public List<PostComment> allposts(String token){
        return postDao.allpost(token);
    }
    public void delposts(String token){
        postDao.delpost(token);
    }
}
