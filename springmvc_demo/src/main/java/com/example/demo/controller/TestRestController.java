package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
    @PostMapping("/test")
    public String testPost()
    {
        System.out.println("测试添加");
        return "testPost";
    }
    @PutMapping("/test")
    public String testPut()
    {
        System.out.println("测试修改");
        return "testPut";
    }
}
