package com.gouhao.frametest.main;

import android.databinding.ObservableField;

import com.gouhao.frame.base.ActivityData;

/**
 * Created by gouhao on 2017/2/4 0004.
 */
public class MainActivityData extends ActivityData{
    public ObservableField<String> buttonText1;
    public ObservableField<String> buttonText2;

    public MainActivityData() {
        buttonText1 = new ObservableField<>();
        buttonText2 = new ObservableField<>();
    }
}
