package com.stylefeng.guns.core.util;

import java.util.UUID;

/**
 * @Author: yyc
 * @Date: 2019/6/9 22:42
 */
public class UuidUtil {
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
