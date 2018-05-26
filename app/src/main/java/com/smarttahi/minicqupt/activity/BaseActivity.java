package com.smarttahi.minicqupt.activity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.tools.ChangeUnit;
import com.smarttahi.minicqupt.tools.Config;

/**
 * Created by SmartTahi on 2018/5/26.
 * 点击空白部分收起软键盘
 * 在该类中保存所有activity中都需要反复用到的方法
 * 保存Data对象实例
 *
 */

@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity {
    TextView TopTitle;
    RelativeLayout Top;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (null != this.getCurrentFocus()) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            assert inputMethodManager != null;
            return inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static boolean isLengthLegal(String str,int Limit) {
        return str.length() > 0 && str.length() < Limit;
    }

//    public static boolean isPasswordLegal(String str) {
//        return str.length() > 6 || str.length() < 18;
//    }

    abstract void setTitle ();
}
