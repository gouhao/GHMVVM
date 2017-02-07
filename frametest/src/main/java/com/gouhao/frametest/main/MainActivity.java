package com.gouhao.frametest.main;

import android.databinding.DataBindingUtil;

import com.gouhao.frame.base.BaseActivity;
import com.gouhao.frametest.R;
import com.gouhao.frametest.databinding.ActivityMainBinding;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public class MainActivity extends BaseActivity<ActivityMainBinding,
        MainModel, MainActivityData> {

    @Override
    protected void initActivityDataBinding() {
        activityDataBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.activity_main, null, false);
    }

    @Override
    protected void initActivityData() {
        activityData = new MainActivityData();
        activityData.buttonText1.set("Button1");
        activityData.buttonText2.set("Show/Hide Label");
        activityData.isShowLabelText.set(true);
        activityData.labelText.set("This is a label!");
        activityDataBinding.setData(activityData);
    }

    @Override
    protected void initActivityModel() {
        activityModel = new MainModel(activityDataBinding);
        activityDataBinding.setModel(activityModel);
    }



    @Override
    protected void initTitle() {
        getTitleBar().setTitleBarTitle("Gouhao");
    }
}
