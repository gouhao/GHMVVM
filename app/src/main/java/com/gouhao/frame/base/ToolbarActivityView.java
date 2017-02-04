package com.gouhao.frame.base;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public class ToolbarActivityView extends ActivityView {
    private Toolbar toolbar;

    public ToolbarActivityView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        initToolbar();
        LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        addView(toolbar, params);
    }

    private void initToolbar() {
        toolbar = new Toolbar(getContext());
    }

    @Override
    public void setTitle(int resId) {
        if(resId >= 0) {
            toolbar.setTitle(resId);
        }

    }

    @Override
    public void setTitle(String title) {
        if(title != null) {
            toolbar.setTitle(title);
        }

    }

    @Override
    public Object getTitleBar() {
        return toolbar;
    }

    @Override
    public void addContentView(int resId) {
        if(resId >= 0) {
            View view = inflate(getContext(), resId, null);
            addContentView(view);
        }
    }

    @Override
    public void addContentView(View view) {
        if(view != null) {
            LinearLayout.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            addView(view, params);
        }
    }

    @Override
    public void addTitleBarRightView(View view) {

    }

    @Override
    public void addTitleBarLeftView(View view) {

    }

    @Override
    public void setTitleBarVisibility(int visibility) {
        toolbar.setVisibility(visibility);
    }

    @Override
    public void setTitleBarTitle(int resId) {
        if(resId >= 0) {
            toolbar.setTitle(resId);
        }
    }

    @Override
    public void setTitleBarTitle(String title) {
        if(title != null) {
            toolbar.setTitle(title);
        }
    }
}
