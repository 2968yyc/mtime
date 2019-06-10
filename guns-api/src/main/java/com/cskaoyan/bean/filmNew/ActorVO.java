package com.cskaoyan.bean.filmNew;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yyc
 * @Date: 2019/6/10 20:03
 */
@Data
public class ActorVO implements Serializable {
    private String imgAddress;
    private String directorName;
    private String roleName;
}
