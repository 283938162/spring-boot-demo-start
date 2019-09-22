package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;


// 返回一个字符串
//@RestController
//public class HelloController {
//    @RequestMapping("/hello")
//    public String hello(){
//        return "Hello Spring Boot!";
//    }
//}


//返回一个重定向视图
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }
}
