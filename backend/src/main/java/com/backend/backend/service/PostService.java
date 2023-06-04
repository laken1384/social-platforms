package com.backend.backend.service;

import com.backend.backend.domin.Posts;
import com.backend.backend.domin.User;
import com.backend.backend.domin.Users;
import com.backend.backend.repository.PostDao;
import com.backend.backend.repository.UserDao;
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
    public List<Posts> personposts(String token){
        return postDao.personpost(token);
    }
    public List<Posts> allposts(String token){
        return postDao.allpost(token);
    }
    public void delposts(String token){
        postDao.delpost(token);
    }
}
