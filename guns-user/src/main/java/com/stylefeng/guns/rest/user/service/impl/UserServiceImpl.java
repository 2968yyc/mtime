package com.stylefeng.guns.rest.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.user.UserRegisterVo;
import com.cskaoyan.service.UserService;
import com.stylefeng.guns.rest.user.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.user.model.MtimeUserT;
import com.stylefeng.guns.rest.user.service.IMtimeUserTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: yyc
 * @Date: 2019/6/4 17:22
 */
@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    IMtimeUserTService iMtimeUserTService;
    @Autowired
    MtimeUserTMapper userTMapper;

    private MtimeUserT userRegisterVo2MtimeUserT(UserRegisterVo userRegisterVo){
        MtimeUserT mtimeUserT = new MtimeUserT();
        mtimeUserT.setUserName(userRegisterVo.getUsername());
        mtimeUserT.setUserPwd(userRegisterVo.getPassword());
        mtimeUserT.setEmail(userRegisterVo.getEmail());
        mtimeUserT.setUserPhone(userRegisterVo.getPhone());
        mtimeUserT.setAddress(userRegisterVo.getAddress());
        return mtimeUserT;
    }
    @Override
    public StatusVo register(UserRegisterVo userRegisterVo) {
        MtimeUserT mtimeUserT = userRegisterVo2MtimeUserT(userRegisterVo);
        mtimeUserT.setBeginTime(new Date());
        mtimeUserT.setUpdateTime(new Date());
        HashMap<String, Object> condition = new HashMap<>();
        condition.put("user_name",mtimeUserT.getUserName());
        List<MtimeUserT> mtimeUserTS = null;
        try {
            mtimeUserTS = iMtimeUserTService.selectByMap(condition);
            if (mtimeUserTS.size()!=0){
                return new StatusVo(1,"用户已存在");
            }
            if(iMtimeUserTService.insert(mtimeUserT)){
                return new StatusVo(0,"注册成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StatusVo(999,"系统出现异常，请联系管理员");

    }

    @Override
    public StatusVo check(String username) {
        HashMap<String, Object> condition = new HashMap<>();
        condition.put("user_name",username);
        List<MtimeUserT> mtimeUserTS = null;
        try {
            mtimeUserTS = iMtimeUserTService.selectByMap(condition);
            if (mtimeUserTS.size()!=0){
                return new StatusVo(1,"用户已存在");
            }
            return new StatusVo(0,"验证成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StatusVo(999,"系统出现异常，请联系管理员");

    }

    @Override
    public String getPwdByUsername(String credenceName) {
        String s = userTMapper.selectPwdByUserName(credenceName);
        return s;
    }
}
