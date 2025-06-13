package com.example.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {
    @RequestMapping("/t1")
    public Integer t1(){
        int a=10/0;
        return 1;
    }
    @RequestMapping("/t2")
    public Boolean t2(){
        return true;
    }
    @RequestMapping("/t3")
    public String t3(){
        return "t3";
    }
}
