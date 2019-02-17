package com.example.ssoshiro.controller;

import com.example.ssoshiro.common.SysResult;
import com.example.ssoshiro.common.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author saki
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/lg")
    public String lg(){
        return "login.html";
    }

    @RequestMapping("/login")
    @ResponseBody
    public SysResult login(User user){
        System.out.println(user);
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));

        return new SysResult();
    }
}
