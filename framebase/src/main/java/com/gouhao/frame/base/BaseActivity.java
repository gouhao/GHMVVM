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
public abstract class BaseActivity<V extends ViewDataBinding, M extends ActivityModel<V>, D extends ActivityData>
        extends AppCompatActivity {
    protected String TAG = getClass().getSimpleName();
    private ActivityLayout activityLayout;

    protected V activityDataBinding;
    protected M activityModel;
    protected D activityData;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        LogUtil.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        initTintStatusBar();

        //在这里设置标题栏的高度
        activityLayout = new ActivityLayout(this, 200);
        setContentView(activityLayout);

        initActivityDataBinding();
        if(activityDataBinding == null) {
            throw new NullPointerException("What the fuck!ActivityDataBinding is null");
        }
        addContentView(activityDataBinding.getRoot());

        initActivityData();
        initActivityModel();

        initTitle();
    }

    protected abstract void initActivityModel();

    protected abstract void initActivityData();

    protected abstract void initTitle();

    protected abstract void initActivityDataBinding();

    private void initTintStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void addContentView(View view) {
        activityLayout.addContentView(view);
    }

    public ITitleBar getTitleBar() {
        return activityLayout.getTitleBar();
    }

    @Override
    protected void onStart() {
        LogUtil.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        LogUtil.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        LogUtil.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LogUtil.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        LogUtil.d(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        LogUtil.d(TAG, "onDestroy");
        super.onDestroy();
    }


}
