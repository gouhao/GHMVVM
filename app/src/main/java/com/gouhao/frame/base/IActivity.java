package com.gouhao.frame.base;

import android.view.View;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public interface IActivity {
    void setTitle(int resId);

    void setTitle(String title);

    Object getTitleBar();

    void addContentView(int resId);

    void addContentView(View view);

    void addTitleBarRightView(View view);

    void addTitleBarLeftView(View view);

    void setTitleBarVisibility(int visibility);

    void setTitleBarTitle(int resId);

    void setTitleBarTitle(String title);

}
