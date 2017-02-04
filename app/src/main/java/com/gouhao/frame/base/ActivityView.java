package com.gouhao.frame.base;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public abstract class ActivityView extends LinearLayout implements IActivity {
    public ActivityView(Context context) {
        super(context);
        setOrientation(VERTICAL);
    }
}
