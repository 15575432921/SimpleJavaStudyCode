package com.example.demo.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestExceptionController {
    @GetMapping(value = {"/testEx"})
    public ModelAndView testModelAndView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("test","hello");
        modelAndView.setViewName("success");
        System.out.println(1/0);
        return modelAndView;
    }
}
