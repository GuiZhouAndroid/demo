package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by on 2021/9/17
 * 描述：
 *
 * @author 1
 * @create 2021-09-17-16:36
 */
@RestController
public class MaiController {
    @Autowired
    JavaMailSender javaMailSender;

    @RequestMapping("/send")
    public String startStart(){
        //创建邮件对象
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("1210762604@qq.com");//发件人
        mailMessage.setTo("1210762604@qq.com");//收件人
        mailMessage.setText("邮箱内容");// //设置发件标题
        javaMailSender.send(mailMessage);//发送邮件
        return "邮箱发送成功！";
    }
}
