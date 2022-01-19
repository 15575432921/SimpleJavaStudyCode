package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;


@Controller
public class HttpMessageConverterTestController {
    @GetMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String>requestEntity)
    {
        System.out.println("请求头： "+requestEntity.getHeaders());
        System.out.println("请求体： "+requestEntity.getBody());
        return "success";
    }
    @GetMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("testResponse");
//        return "success";
    }
    @ResponseBody
    @GetMapping("/testResponseBody")
    public String testResponseBody() {
    return "testResponseBody";
    }
//    @ResponseBody
    @GetMapping("/testFileDownload")
    public ResponseEntity<byte[]> testFileDownload(HttpSession session) throws Exception{
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/static/1.jpg");
        realPath="F:\\code\\SimpleJavaStudyCode-master\\springmvc_demo\\src\\main\\resources\\static\\1.jpg";
        FileInputStream fileInputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        fileInputStream.close();
        return responseEntity;
    }
    @PostMapping("/testUp")
    @ResponseBody
    public String testUp(@RequestParam(value = "file") MultipartFile file) throws IOException {
        file.transferTo(new File("F:\\code\\SimpleJavaStudyCode-master\\springmvc_demo\\src\\main\\resources\\static\\2.jpg"));
        return "testUp";
    }
}
