package com.example.book.model;

import com.example.book.enums.ResultCodeEnum;
import lombok.Data;

@Data
public class Result<T> {
    private ResultCodeEnum code; //-1 未登录；-2 出错； 200 正常
    private String errMsg;
    private T data;

    public static <T> Result success(T data){
        Result result=new Result();
        result.setCode(ResultCodeEnum.SUCCESS);
        result.setErrMsg("");
        result.setData(data);
        return result;
    }
    public static Result fail(String errMsg){
        Result result=new Result();
        result.setCode(ResultCodeEnum.FALL);
        result.setErrMsg(errMsg);
        result.setData(null);
        return result;
    }
    public Result fail(String errMsg, T data){
        Result result=new Result();
        result.setCode(ResultCodeEnum.FALL);
        result.setErrMsg(errMsg);
        result.setData(data);
        return result;
    }
    public static <T> Result unLogin(){
        Result result=new Result();
        result.setCode(ResultCodeEnum.UNLOGIN);
        result.setErrMsg("用户未登录");
        return result;
    }
}
