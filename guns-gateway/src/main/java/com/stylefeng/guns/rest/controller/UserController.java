package com.stylefeng.guns.rest.controller;

import com.cskaoyan.bean.StatusVo;
import com.cskaoyan.bean.user.UserRegisterVo;
import com.cskaoyan.service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;
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
        return userService.register(userRegisterVo);

    }







}
