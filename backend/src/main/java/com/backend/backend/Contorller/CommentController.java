package com.backend.backend.Contorller;

import com.backend.backend.domin.Comments;

import com.backend.backend.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081", methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/addcomment")//新增留言
    public ResponseEntity<Comments> create_post(@RequestBody Comments data, @CookieValue(value = "token") String token) {
        UUID uuid1 = UUID.randomUUID();// uuid
        String uuidString1 = uuid1.toString();

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = localDateTime.format(formatter);

        data.setCommentID(uuidString1);
        data.setUserID(token);
        data.setCreateAt(formattedDateTime);
        commentService.addcomments(data);
        System.out.println(data);
        return new ResponseEntity<Comments>(data, HttpStatus.OK);
    }
}
