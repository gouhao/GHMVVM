package com.gouhao.frametest.main;

import android.databinding.ViewDataBinding;
import android.util.Log;

import com.gouhao.frame.base.ActivityModel;


/**
 * Created by gouhao on 2017/2/3 0003.
 */

public class MainModel extends ActivityModel {
    public MainModel(ViewDataBinding dataBinding) {
        super(dataBinding);
    }

    public void buttonClick1() {
        Log.d(TAG, "button1 click");
    }

    public void buttonClick2() {
        Log.d(TAG, "button2 click");
    }
}
