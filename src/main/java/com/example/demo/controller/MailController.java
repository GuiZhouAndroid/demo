package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.InternetAddress;

/**
 * created by on 2021/9/17
 * 描述：发送QQ邮箱
 *
 * @author ZSAndroid
 * @create 2021-09-17-16:36
 */
@RestController
public class MailController {

    //注入邮箱服务
    @Autowired JavaMailSender javaMailSender;

    //发件人：开发者自定义发件人邮箱，对应yml和QQ邮箱官方的密钥用户
    private static final String sender_qq_email = "1210762604@qq.com";

    @RequestMapping("/send")
    public String startStart(){
        sendQQEmail("1210762604@qq.com","邮箱内容");
        return "邮箱发送成功！";
    }

    /**
     * 发送邮箱
     * @param registerRecipients 收件人QQ邮箱
     * @param emailContent 邮箱内容
     */
    public void sendQQEmail(String registerRecipients, String emailContent) {
        try {
            //创建邮件对象
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(String.valueOf(new InternetAddress(sender_qq_email)));//发件人
            mailMessage.setTo(registerRecipients);//收件人
            mailMessage.setText(emailContent);// //设置发件标题
            javaMailSender.send(mailMessage);//发送邮件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
