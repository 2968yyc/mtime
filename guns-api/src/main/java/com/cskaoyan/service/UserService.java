package com.cskaoyan.service;

import com.cskaoyan.bean.AllVo;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.user.UserRegisterVo;
import com.cskaoyan.bean.user.UserUpdate;
import com.cskaoyan.bean.vo.Vo;

/**
 * @Author: yyc
 * @Date: 2019/6/4 17:03
 */
public interface UserService {
    StatusVo register(UserRegisterVo userRegisterVo);

    StatusVo check(String username);

    String getPwdByUsername(String credenceName);

    Vo getUserInfo();

    AllVo updateUserInfo(UserUpdate userUpdate);

    int getUserIdByUsername(String username);
}
