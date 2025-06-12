package com.example.book.controller;

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
    public Boolean login(String userName, String password, HttpSession session){
        //1.参数校验
        if (!StringUtils.hasLength(userName)||!StringUtils.hasLength(password)){
            return false;
        }
        UserInfo userInfo= userInfoService.queryUserInfoByName(userName);
        if (userInfo==null){
            return false;
        }
        if (password.equals(userInfo.getPassword())){
            userInfo.setPassword("");
            session.setAttribute("session_user_info",userInfo);
            return true;
        }
        return false;
    }
}
