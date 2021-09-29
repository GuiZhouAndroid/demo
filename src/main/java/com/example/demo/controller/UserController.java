package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * created by on 2021/9/18
 * 描述：
 *
 * @author 1
 * @create 2021-09-18-15:06
 */

@Controller
@RequestMapping("/user/")
public class UserController {
    @RequestMapping("/index")
    public String show() {
        return "index";
    }
    //http://localhost:8080/user/register?username=张松&password=root
    //RequestParam(对应URL问号后面的 + = 号左边的username值，默认必须为空)——可以省略，会自动提取URL的参数，用于与形式参数区分，标识作用
    @RequestMapping("register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
        //User user2 = new User(username,password);构造方法初始化用户数据，数据来源与URL地址的用户名和密码
        User user = new User();//创建一个用户对象
        //把URL中的手动输入的用户名设置到User的set方法中
        user.setUsername(username);
        //把URL中的手动输入的密码设置到User的set方法中
        user.setPassword(password);
        /** 此时new出来的 user对象，已经存放携带了用户名和密码 */
        // 规定返回Json格式的数据——{"username":"张松","password":"root"}
        return "用户=" + user.getUsername() + ",密码=" + user.getPassword();//，把携带user数据的用户信息，返回至前端页面
    }
    @RequestMapping("register2")
    public String register2(String username,String password) {
        //select * from user where username = username} and password = password
        if (username.equals("张松") && password.equals("root")){
            return  "success";
        }
        return  "error";
        //return username.equals("张松") && password.equals("root") ? "success":"error";
    }
}
