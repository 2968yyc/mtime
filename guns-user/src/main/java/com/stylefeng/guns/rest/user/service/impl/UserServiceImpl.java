package com.stylefeng.guns.rest.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cskaoyan.AliveUser;
import com.cskaoyan.bean.AllVo;
import com.cskaoyan.bean.vo.DataVo;
import com.cskaoyan.bean.vo.StatusVo;
import com.cskaoyan.bean.user.UserRegisterVo;
import com.cskaoyan.bean.user.UserUpdate;
import com.cskaoyan.bean.vo.Vo;
import com.cskaoyan.service.UserService;
import com.stylefeng.guns.core.util.MD5Util;
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
        mtimeUserT.setUserPwd(MD5Util.encrypt(userRegisterVo.getPassword()));
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

    @Override
    public Vo getUserInfo(String userName) {

        if (userName != null && userName.trim().length() != 0) {
            MtimeUserT mtimeUserT = new MtimeUserT();
            mtimeUserT.setUserName(userName);
            MtimeUserT aftermtimeUserT = userTMapper.selectOne(mtimeUserT);
            if (aftermtimeUserT != null) {
                return new DataVo(0,  aftermtimeUserT);
            } else {
                return new StatusVo(999, "系统出现异常，请联系管理员");
            }
        } else {
            return new StatusVo(1, "查询失败，用户尚未登陆");
        }
    }

    @Override
    public AllVo updateUserInfo(UserUpdate userUpdate) {
        String userName = userUpdate.getUsername();
        if (userName != null && userName.trim().length() > 0) {
            //要修改的username与当前threadlocal里的username是否一致，来判断是否登录
            if (userName.equals(userUpdate.getUsername())) {
                MtimeUserT mtimeUserT = new MtimeUserT();
                mtimeUserT.setUserName(userUpdate.getUsername());
                mtimeUserT.setUuid(userUpdate.getUuid());
                mtimeUserT.setNickName(userUpdate.getNickname());
                mtimeUserT.setLifeState(Integer.parseInt(userUpdate.getLifeState()));
                mtimeUserT.setBirthday(userUpdate.getBirthday());
                mtimeUserT.setBiography(userUpdate.getBiography());
                mtimeUserT.setHeadUrl(userUpdate.getAddress());
                mtimeUserT.setEmail(userUpdate.getEmail());
                mtimeUserT.setAddress(userUpdate.getAddress());

                mtimeUserT.setUserSex(userUpdate.getSex());
                mtimeUserT.setBeginTime(null);
                mtimeUserT.setUpdateTime(new Date());
                Integer integer = userTMapper.updateById(mtimeUserT);
                if (integer > 0) {
                    return new AllVo(0, "", mtimeUserT);
                } else {
                    return new AllVo(1, "用户信息修改失败", null);
                }
            }
        }
        return new AllVo(1, "查询失败，用户尚未登陆", null);
    }

    @Override
    public int getUserIdByUsername(String username) {
        int uid = userTMapper.selectUidByUsername(username);
        return uid;
    }
}
