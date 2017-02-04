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
    private ActivityLayout activityLayout;

    protected V activityDataBinding;
    protected M activityModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLayout = new ActivityLayout(this, 200);
        setContentView(activityLayout);
        initActivityDataBinding();
        if(activityDataBinding == null) {
            throw new NullPointerException("What the fuck!ActivityDataBinding is null");
        }

        initActivityModel();
        if(activityModel == null) {
            throw new NullPointerException("What the fuck!ActivityMode is null");
        }
        initTitle();
    }

    protected abstract void initTitle();

    protected abstract void initActivityModel();

    protected abstract void initActivityDataBinding();

    public void addContentView(View view) {
        activityLayout.addContentView(view);
    }

    public ITitleBar getTitleBar() {
        return activityLayout.getTitleBar();
    }
}
