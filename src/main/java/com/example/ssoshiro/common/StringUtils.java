package com.example.ssoshiro.common;


public class StringUtils {

    public static boolean isNotBlank(String str){
        if ("".trim().equals(str)||str==null){
            return false;
        }else {
            return true;//测试冲突
        }
    }
}
