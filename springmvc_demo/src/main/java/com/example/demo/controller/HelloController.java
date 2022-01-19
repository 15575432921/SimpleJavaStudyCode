package com.example.demo.controller;


import com.example.demo.entity.User;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/test1")
    public String test1() {
        return "hello test1";
    }

    @GetMapping(value = {"/testParams"}, params = {"name", "!password", "name!=wzh"})
    public String testParams(@RequestParam("name") String name) {
        System.out.println(name);
        return "testParams";
    }

    @GetMapping(value = {"/testHeaders"}, headers = {"Host!=localhost:8080"})
    public String testHeaders() {
        return "testHeaders";
    }

    //任意单个字符 aaa a+a
    @GetMapping(value = {"/a?a/testAnt"})
    public String testAnt() {
        return "testAnt";
    }

    //*表示任意的0个或多个字符
    @GetMapping(value = {"/a*a/testAnt1"})
    public String testAnt1() {
        return "testAnt1";
    }

    //**表示任意的一层或多层目录
//    Fix this pattern in your application or switch to the legacy parser implementation with 'spring.mvc.pathmatch.matching-strategy=ant_path_matcher'.
    @GetMapping(value = {"/**/testAnt2"})
    public String testAnt2() {
        return "testAnt2";
    }

    @GetMapping(value = {"/testRest/{id}/{username}"})
    public String testRest(@PathVariable("id") int id, @PathVariable("username") String username) {
        System.out.println(id + " " + username);
        return "testRest";
    }

    @GetMapping(value = {"/testRequestParam"})
    public String testRequestParam(@RequestParam("username") String[] username, HttpServletRequest request) {
        System.out.println(Arrays.toString(username));
//        System.out.println(request.getParameter("username"));
        return "testRequestParam";
    }

    @GetMapping(value = {"/testRequestHeader"})
    public String testRequestHeader(@RequestHeader("Host") String host) {
        System.out.println(host);
        return "testRequestHeader";
    }

    @GetMapping(value = {"/testCookieValue"})
    public String testCookieValue(@CookieValue(value = "JSESSIONID", defaultValue = "test") String session) {
        System.out.println(session);
        return "testCookieValue";
    }

    @GetMapping(value = {"/testPOJO"})
    public String testPOJO(User user) {
        System.out.println(user);
        return user.toString();
    }

    @GetMapping(value = {"/testSetAttribute"})
    public String testSetAttribute(HttpServletRequest request) {
        request.setAttribute("test", "hello");
        return "testSetAttribute";
    }

    @GetMapping(value = {"/testModel"})
    public String testModel(Model model) {
        model.addAttribute("test", "hello model");
        return "testModel";
    }

    @GetMapping(value = {"/testMap"})
    public String testMap(Map<String, Object> mp) {
        mp.put("test", "hello Map");
        System.out.println(mp.getClass().getName());
        return "testMap";
    }

    @GetMapping(value = {"/testModelMap"})
    public String testModelMap(ModelMap mp) {
        mp.put("test", "hello ModelMap");
        System.out.println(mp.getClass().getName());
        return "testModelMap";
    }

    @GetMapping(value = {"/testSession"})
    public String testSession(HttpSession session) {
        session.setAttribute("testSession", "hello,session");
        return "testSession";
    }
    @GetMapping(value = {"/getSession"})
    public String getSession(HttpSession session) {
        System.out.println(session.getAttribute("testSession"));
        return "getSession";
    }
    @GetMapping(value = {"/testServletContext"})
    public String testServletContext(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        for (; attributeNames.hasMoreElements();)
            System.out.println(attributeNames.nextElement());
        servletContext.setAttribute("testSession", "hello,servletContext");
        return "testServletContext";
    }
}
