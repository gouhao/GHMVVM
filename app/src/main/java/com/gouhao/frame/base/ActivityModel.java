package com.gouhao.frame.base;

import android.databinding.ViewDataBinding;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public abstract class ActivityModel implements IModel{
    protected String TAG = getClass().getSimpleName();
    private ViewDataBinding viewDataBinding;

    public ActivityModel(ViewDataBinding dataBinding) {
        viewDataBinding = dataBinding;
    }
}
