package com.example.demo.controller;

import com.example.demo.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HelloController {
    @Autowired
    @Qualifier("tom")
    Cat cat;

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> header,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("inters") List<String> inters,
                                      @RequestParam Map<String, String> params,
                                      @CookieValue("_ga") String _ga,
                                      @CookieValue("_ga") Cookie cookie) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("headers", header);
        map.put("age", age);
        map.put("inters", inters);
        map.put("params", params);
        map.put("_ga", _ga);
        System.out.println(cookie.getName() + "===>" + cookie.getValue());
        return map;
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println(cat.getName());
        return "hello";
    }

    @GetMapping("/test")
    public String test(@RequestParam("name") String name) {

        return name;
    }

    //矩阵变量  /cars/sell;low=34;brand=byd,audi,yd
    @GetMapping("/cars/{path}")
    public String carsSell(@MatrixVariable("low") Integer low, @MatrixVariable("brand") List<String> brand,
                           @PathVariable("path") String path) {
        System.out.println("path: " + path);
        return low.toString();
    }
}
