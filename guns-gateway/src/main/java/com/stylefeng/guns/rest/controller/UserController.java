package com.stylefeng.guns.rest.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cskaoyan.AliveUser;
import com.cskaoyan.bean.AllVo;
import com.cskaoyan.bean.vo.DataVo;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.user.UserRegisterVo;
import com.cskaoyan.bean.user.UserUpdate;
import com.cskaoyan.bean.vo.Vo;
import com.cskaoyan.service.UserService;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("logout")
    public StatusVo logout(){
        AliveUser.cleanThread();
        return new StatusVo(0,"成功退出");
    }

    @GetMapping("getUserInfo")
    public Vo getUserInfo(){
        String userName = AliveUser.getThread();
        return userService.getUserInfo(userName);
    }

    @PostMapping("updateUserInfo")
    public Vo updateUserInfo(String uuid,String email,String sex,String birthday,String lifeState,String biography,String address,
                             String updateTime){
        UserUpdate userUpdate = new UserUpdate();
        String userName = AliveUser.getThread();
        userUpdate.setUsername(userName);
        userUpdate.setUuid(Integer.parseInt(uuid));
        userUpdate.setEmail(email);
        userUpdate.setSex(Integer.parseInt(sex));
        userUpdate.setBirthday(birthday);
        userUpdate.setLifeState(lifeState);
        userUpdate.setBiography(biography);
        userUpdate.setAddress(address);
        return userService.updateUserInfo(userUpdate);
    }
}
