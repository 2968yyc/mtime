package com.cskaoyan;

/**
 * @Author : zjf
 * @Date : 2019/6/5 下午 03:32
 */
public class AliveUser {
    private static final ThreadLocal<String> thread = new ThreadLocal<>();
    public static void setThread(String userName){
        thread.set(userName);
    }
    public static String getThread(){
        return thread.get();
    }
}
