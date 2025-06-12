package com.example.book.controller;

import com.example.book.constant.Constants;
import com.example.book.model.UserInfo;
import com.example.book.service.UserInfoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/login")
    public Boolean login(String name, String password, HttpSession session){
        System.out.println("[Debug   UserController25  userName]"+name);
        System.out.println("[Debug   UserController25  password]"+password);

        //1.参数校验
        if (!StringUtils.hasLength(name)||!StringUtils.hasLength(password)){
            return false;
        }
        UserInfo userInfo= userInfoService.queryUserInfoByName(name);
        System.out.println("[Debug   UserController25  userInfo]"+userInfo);
        if (userInfo==null){

            return false;
        }
        if (password.equals(userInfo.getPassword())){
            userInfo.setPassword("");
            session.setAttribute(Constants.SESSION_USER_KEY,userInfo);
            return true;
        }
        return false;
    }
}
