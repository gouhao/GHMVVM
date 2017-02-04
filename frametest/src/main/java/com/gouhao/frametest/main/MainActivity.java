package com.gouhao.frametest.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gouhao.frame.base.ActivityModel;
import com.gouhao.frame.base.BaseActivity;
import com.gouhao.frametest.R;
import com.gouhao.frametest.databinding.ActivityMainBinding;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, ActivityModel> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addContentView(activityDataBinding.getRoot());
    }

    @Override
    protected void initTitle() {
        getTitleBar().setTitleBarTitle("Gouhao");
    }

    @Override
    protected void initActivityModel() {
        activityModel = new MainModel(activityDataBinding);
    }

    @Override
    protected void initActivityDataBinding() {
        activityDataBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.activity_main, null, false);
        MyButton button1 = new MyButton();
        button1.text.set("Click1");
        MyButton button2 = new MyButton();
        button2.text.set("Click2");

        activityDataBinding.setButton1(button1);
        activityDataBinding.setButton2(button2);
    }
}
