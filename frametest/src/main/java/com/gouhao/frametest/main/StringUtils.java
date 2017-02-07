package com.gouhao.frametest.main;

/**
 * Created by gouhao on 2017/2/7 0007.
 */
public class StringUtils {
    public static String convertString(String str) {
        if(str == null) return "null";
        return str.toUpperCase();
    }
}
