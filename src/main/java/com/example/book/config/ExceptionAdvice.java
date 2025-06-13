package com.example.book.config;

import com.example.book.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    public Result hander(Exception e){
        log.error("发生异常，e:",e);
        return Result.fail("内部异常，请联系管理员");
    }
    @ExceptionHandler
    public Result hander(NullPointerException e){
        log.error("发生异常，e:",e);
        return Result.fail("空指针异常，请联系管理员");
    }
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public Result hander(IndexOutOfBoundsException e){
        log.error("发生异常，e:",e);
        return Result.fail("内部异常，请联系管理员");
    }
}
