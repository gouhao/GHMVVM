package com.gouhao.frame.base;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public abstract class BaseActivity<V extends ViewDataBinding, M extends ActivityModel> extends AppCompatActivity {
    private ActivityView activityView;

    protected V activityDataBinding;
    protected M activityModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityView = new ToolbarActivityView(this);
        setContentView(activityView);
        initActivityDataBinding();
        if(activityDataBinding == null) {
            throw new NullPointerException("What the fuck!ActivityDataBinding is null");
        }

        initActivityModel();
        if(activityModel == null) {
            throw new NullPointerException("What the fuck!ActivityMode is null");
        }
    }

    protected abstract void initActivityModel();

    protected abstract void initActivityDataBinding();

    public void addContentView(View view) {
        activityView.addContentView(view);
    }

    public void removeTitleBar() {
        activityView.setTitleBarVisibility(View.GONE);
    }

    public void showTitleBar() {
        activityView.setTitleBarVisibility(View.VISIBLE);
    }

    public void setTitleBarTitle(int resId) {
        activityView.setTitleBarTitle(resId);
    }

    public void setTitleBarTitle(String title) {
        activityView.setTitleBarTitle(title);
    }

    public void addTitleBarRightView(View view) {
        activityView.addTitleBarRightView(view);
    }

    public void addTitleBarLeftView(View view) {
        activityView.addTitleBarLeftView(view);
    }
}
