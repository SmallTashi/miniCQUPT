package com.smarttahi.cquptinhand.tools;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.smarttahi.cquptinhand.Data.User;

public class MyApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    protected static Context thisContext;
    public static User user;

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
