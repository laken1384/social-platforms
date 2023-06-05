package com.backend.backend.Contorller;

import com.backend.backend.domin.Comment.PostComment;
import com.backend.backend.domin.Posts;
import com.backend.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081", methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/create_post")//註冊
    public ResponseEntity<Posts> create_post(@RequestBody Posts data, @CookieValue(value = "token") String token) {
        UUID uuid1 = UUID.randomUUID();// uuid
        String uuidString1 = uuid1.toString();

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = localDateTime.format(formatter);

        data.setPostID(uuidString1);
        data.setUserID(token);
        data.setCreatedAt(formattedDateTime);
        postService.addposts(data);
        return new ResponseEntity<Posts>(data, HttpStatus.OK);
    }

    @GetMapping("/personpost")//取得個人貼文
    public ResponseEntity<List<PostComment>> personpost(@CookieValue(value = "token") String token) {
        System.out.println("token" + token);
        List<PostComment> result = postService.personposts(token);
        return new ResponseEntity<List<PostComment>>(result, HttpStatus.OK);
    }
    @GetMapping("/allpost")//取得全部貼文
    public ResponseEntity<List<PostComment>> allpost(@CookieValue(value = "token") String token) {
        System.out.println("token" + token);
        List<PostComment> result = postService.allposts(token);
        return new ResponseEntity<List<PostComment>>(result, HttpStatus.OK);
    }
    @PostMapping("/delpost")
    private String delpost(@CookieValue(value = "token") String token, @RequestBody Posts data) {
        System.out.println(token + "/" + data.getUserID()+ "/" + data.getPostID());

        postService.delposts(data.getPostID());
        return "OK";

    }
}