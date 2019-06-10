package com.cskaoyan.bean.filmNew;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yyc
 * @Date: 2019/6/10 19:04
 */
@Data
public class FilmDetailVO implements Serializable {
    private String filmId;
    private String filmName;
    private String filmEnName;
    private String imgAddress;
    private String score;
    private String scoreNum;
    private String totalBox;
    private String info01;
    private String info02;
    private String info03;
    private InfoResponseVO info04;

}
