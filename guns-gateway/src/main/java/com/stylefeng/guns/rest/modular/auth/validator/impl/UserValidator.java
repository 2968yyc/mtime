package com.stylefeng.guns.rest.modular.auth.validator.impl;

import com.alibaba.dubbo.config.annotation.Reference;

import com.cskaoyan.service.UserService;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.rest.modular.auth.validator.dto.Credence;


import org.springframework.stereotype.Component;

/**
 * @Author: yyc
 * @Date: 2019/6/4 20:05
 */
@Component("userValidator")
public class UserValidator implements IReqValidator {
    @Reference
    UserService userService;

    @Override
    public boolean validate(Credence credence) {
        String pwd = userService.getPwdByUsername(credence.getCredenceName());
        return MD5Util.encrypt(credence.getCredenceCode()).equals(pwd);
    }
}
