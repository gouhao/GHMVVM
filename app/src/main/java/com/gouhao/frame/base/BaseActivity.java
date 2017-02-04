package com.gouhao.frame.base;

import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public abstract class BaseActivity<V extends ViewDataBinding, M extends ActivityModel> extends AppCompatActivity {
    private ActivityLayout activityLayout;

    protected V activityDataBinding;
    protected M activityModel;

    protected SystemBarTintManager tintManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTintStatus();
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

    private void setTintStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.setStatusBarColor(Color.TRANSPARENT);
        }
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
