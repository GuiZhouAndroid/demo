package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by on 2021/9/17
 * 描述：
 *
 * @author 1
 * @create 2021-09-17-13:12
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "index";
    }
}
