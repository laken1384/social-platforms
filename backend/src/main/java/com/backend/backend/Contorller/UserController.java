package com.backend.backend.Contorller;

import com.backend.backend.domin.User;
import com.backend.backend.domin.Users;
import com.backend.backend.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081", methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")//註冊
    public ResponseEntity<Users> Sign_up(@RequestBody Users data) {
//        String o = PasswordEncoderUtils.encodePassword(data.getPassword());
        data.setPassword(PasswordEncoder.encode(data.getPassword()));
        UUID uuid1 = UUID.randomUUID();// uuid
        String uuidString1 = uuid1.toString();
        Users tUser = new Users();
//        System.out.println("email : " + data.getEmail());
//        System.out.println("username : " + data.getUserName());
        data.setUserID(uuidString1);
//        System.out.println("apple : " + data.getEmail());
        userService.addUsers(data);// sql
        return new ResponseEntity<Users>(data, HttpStatus.OK);
    }

    @PostMapping("/login")//登陸
    public ResponseEntity<Users> login(@RequestBody Users data, HttpServletResponse response) {
//        String o = PasswordEncoderUtils.encodePassword(data.getPassword());
        data.setPassword(PasswordEncoder.encode(data.getPassword()));
        String token = userService.account_login(data);
        if (token.length() > 0) {
            Cookie cookie = new Cookie("token", token);// 建立一個Cookie 物件
            cookie.setMaxAge(30*60);// 設置過期時間，若無設置時間，其生命週期將持續到Session 過期為止
            cookie.setHttpOnly(true);// 設置為不能被JS 訪問的Cookie
            response.addCookie(cookie);// 將Cookie 物件加入Response 中
        } else {
            System.out.println("token : "+token);
            System.out.println("username : "+data.getUserName());
        }
//        System.out.println("token : " + token);
        return new ResponseEntity<Users>(data, HttpStatus.OK);
    }


    // 讀取Cookie
    @RequestMapping(value = "/getCookie", method = RequestMethod.GET)
    public String getCookie(@CookieValue(value = "username") String username) {

        return "Hello! " + username;
    }


}