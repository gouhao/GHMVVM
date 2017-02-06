package com.gouhao.frame.base;

import android.databinding.ViewDataBinding;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public abstract class ActivityModel<T extends ViewDataBinding> implements IModel{
    protected String TAG = getClass().getSimpleName();
    protected T viewDataBinding;

    public ActivityModel(T dataBinding) {
        viewDataBinding = dataBinding;
    }
}
