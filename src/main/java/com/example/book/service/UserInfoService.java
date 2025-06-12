package com.example.book.service;

import com.example.book.mapper.UserInfoMapper;
import com.example.book.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public UserInfo queryUserInfoByName(String userName) {
        return userInfoMapper.queryUserByName(userName);
    }
}
