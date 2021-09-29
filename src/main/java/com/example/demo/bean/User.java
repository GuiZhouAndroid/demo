package com.example.demo.bean;
import lombok.Data;

/**
 * created by on 2021/9/18
 * 描述：
 *
 * @author 1
 * @create 2021-09-18-15:04
 */

@Data
public class User {
    private String username;
    private String password;
    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
