package com.cskaoyan.bean.filmNew;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yyc
 * @Date: 2019/6/10 20:34
 */
@Data
public class InfoResponseVO implements Serializable {

    private String biography;
    private ActorResponseVO actors;
    private ImgVO imgVO;
    private String filmId;
}
