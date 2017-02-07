package com.gouhao.frametest.main;

import android.util.Log;

import com.gouhao.frame.base.ActivityModel;
import com.gouhao.frametest.databinding.ActivityMainBinding;


/**
 * Created by gouhao on 2017/2/3 0003.
 */

public class MainModel extends ActivityModel<ActivityMainBinding> implements IMainModel {
    public MainModel(ActivityMainBinding dataBinding) {
        super(dataBinding);
    }

    @Override
    public void buttonClick1() {
        Log.d(TAG, "button1 click");
        viewDataBinding.getData().buttonText1.set("button1 click");
    }

    @Override
    public void buttonClick2() {
        Log.d(TAG, "button2 click");
        MainActivityData data = viewDataBinding.getData();
        data.isShowLabelText.set(!data.isShowLabelText.get());
    }
}
