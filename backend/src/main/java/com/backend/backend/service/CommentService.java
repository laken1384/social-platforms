package com.backend.backend.service;

import com.backend.backend.domin.Comments;
import com.backend.backend.domin.Posts;
import com.backend.backend.repository.CommentDao;
import com.backend.backend.repository.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentDao commentDaoDao;
    public void addcomments(Comments comment){
        commentDaoDao.addcomment(comment);
    }
}
