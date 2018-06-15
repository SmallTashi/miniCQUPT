package com.smarttahi.minicqupt.activity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smarttahi.minicqupt.Data.User;
import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.tools.ChangeUnit;
import com.smarttahi.minicqupt.tools.Config;
import com.smarttahi.minicqupt.tools.MyApplication;

/**
 * Created by SmartTahi on 2018/5/26.
 * 点击空白部分收起软键盘
 * 在该类中保存所有activity中都需要反复用到的方法
 * 保存Data对象实例
 */

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    public TextView TopTitle;
    public ImageView Left;
    public TextView Right;
    public RelativeLayout Top;
    public ImageButton RightButton;


    public void setTitle(String s) {

        Top = findViewById(R.id.top_bar);
        TopTitle = findViewById(R.id.top_title_center_text);
        Left = findViewById(R.id.top_title_left_back);
        Right = findViewById(R.id.top_title_right_text);
        RightButton = findViewById(R.id.top_title_right_back);
        TopTitle.setText(s);
    }

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

}
