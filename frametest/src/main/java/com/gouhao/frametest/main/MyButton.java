package com.gouhao.frametest.main;

import android.databinding.ObservableField;
import android.util.Log;

/**
 * Created by gouhao on 2017/2/3 0003.
 */
public class MyButton {
    private final String TAG = getClass().getSimpleName();
    public ObservableField<String> text = new ObservableField<>();
    public void handler(){
        Log.d(TAG, "I am button + " + text.get());
    }
}
