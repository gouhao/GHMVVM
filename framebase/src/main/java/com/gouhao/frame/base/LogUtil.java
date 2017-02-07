package com.gouhao.frame.base;

import android.util.Log;

/**
 * Created by gouhao on 2017/2/7 0007.
 */
public class LogUtil {
    public static boolean IS_DEBUG = true;

    public static void d(String tag, String msg) {
        if(IS_DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if(IS_DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if(IS_DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if(IS_DEBUG) {
            Log.v(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if(IS_DEBUG) {
            Log.w(tag, msg);
        }
    }
}
