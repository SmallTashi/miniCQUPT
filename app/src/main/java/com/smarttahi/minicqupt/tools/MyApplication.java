package com.smarttahi.minicqupt.tools;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.smarttahi.minicqupt.Data.User;

//import com.smarttahi.cquptinhand.Data.User;

public class MyApplication extends Application {
    public static final int ANSWER_LIST = 0;
    public static final int QUESTION_LIST = 1;
    public static final int MINE_LIST = 2;
    public static final int ANSWER_DETAIL = 3;

    public static User user;
    @SuppressLint("StaticFieldLeak")
    protected static Context thisContext;
//    public static User user;

    @Override
    public void onCreate() {
        super.onCreate();
        thisContext = getApplicationContext();

    }
    public static Context getThisContext(){
        return thisContext;
    }

    public static void setUser(User user) {
        MyApplication.user = user;
    }

    public static User getUser() {
        return user;
    }
}
