package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.bean.StatusVo;
import com.cskaoyan.bean.user.UserRegisterVo;
import com.cskaoyan.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yyc
 * @Date: 2019/6/4 17:00
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Reference
    UserService userService;


    @PostMapping("register")
    public StatusVo register(UserRegisterVo userRegisterVo){
        try {
            StatusVo register = userService.register(userRegisterVo);
            return register;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StatusVo(999,"系统出现异常，请联系管理员");
    }
    @PostMapping("check")
    public StatusVo check(String username){
        return userService.check(username);
    }







}
