package com.example.book.mapper;

import com.example.book.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    @Select("select * from user_info where user_name=#{userName}")
    UserInfo queryUserByName(String userName);
}
