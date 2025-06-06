package com.example.book;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String name, String password, HttpSession session){
        //1.参数校验
        if (!StringUtils.hasLength(name)||!StringUtils.hasLength(password)){
            return false;
        }
        if ("admin".equals(name)&&"admin".equals(password)){
            session.setAttribute("userName",name);
            return true;
        }
        return false;
    }
}
