package com.cskaoyan.service;

import com.cskaoyan.bean.StatusVo;
import com.cskaoyan.bean.user.UserRegisterVo;

/**
 * @Author: yyc
 * @Date: 2019/6/4 17:03
 */
public interface UserService {
    StatusVo register(UserRegisterVo userRegisterVo);

    StatusVo check(String username);

    String getPwdByUsername(String credenceName);
}