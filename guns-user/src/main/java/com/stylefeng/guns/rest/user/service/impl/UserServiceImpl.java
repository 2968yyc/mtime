package com.stylefeng.guns.rest.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.bean.StatusVo;
import com.cskaoyan.bean.user.UserRegisterVo;
import com.cskaoyan.service.UserService;
import com.stylefeng.guns.rest.user.service.IMtimeUserTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: yyc
 * @Date: 2019/6/4 17:22
 */
@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    IMtimeUserTService iMtimeUserTService;


    @Override
    public StatusVo register(UserRegisterVo userRegisterVo) {
        return null;
    }
}
