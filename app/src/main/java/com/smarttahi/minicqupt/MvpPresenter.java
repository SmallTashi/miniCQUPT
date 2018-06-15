package com.smarttahi.minicqupt;

import android.content.Intent;
import android.util.Log;

import com.smarttahi.minicqupt.Data.User;
import com.smarttahi.minicqupt.activity.LoginActivity;
import com.smarttahi.minicqupt.activity.TestActivity;
import com.smarttahi.minicqupt.tools.JSONmanager;
import com.smarttahi.minicqupt.tools.MyApplication;

public class MvpPresenter implements Contract.Presenter {
    private Contract.MvpView mvpView;
    private Contract.MvpCallBack mvpCallBack;
    private MvpModel modal;

    public MvpPresenter(Contract.MvpView mvpView) {
        this.mvpView = mvpView;
        setMvpModel();
        modal = new MvpModel(mvpCallBack);
    }

    private void setMvpModel(){

         mvpCallBack = new Contract.MvpCallBack() {
            @Override
            public void onSuccess(String s,String data) {
               User user= JSONmanager.checkUser(s,data);
               if(user!=null){
                   Log.d("show",data);
                   mvpView.addToast(data);
                   mvpView.addToast("Success Login! please waite a minute");
                   MyApplication.setUser(user);
                   mvpView.showHome();
               }
            }

            @Override
            public void onFailed() {
                mvpView.addToast("User name or password is wrong, please checkout and try again");
            }

            @Override
            public void onError(String s) {
                mvpView.addToast("Network failure,please check your internet state");
            }
        };

    }

    @Override
    public void disagree() {
        exitLogin();
    }

    @Override
    public void agree() {
        mvpView.showHome();
    }

    @Override
    public void exitLogin() {
        MyApplication.setUser(null);
        mvpView.addToast("Exit success");
    }

    @Override
    public void login(String name, String paw) {
        if (name.equals("") || paw.equals("")||name.length() != 10 || paw.length() != 6) {
            mvpView.addToast("Please complete your login information");
        } else {
            modal.check(name,paw);
        }
    }

    @Override
    public void checkState() {
        if(!MyApplication.IS_LOGIN){
            mvpView.addToast("No login information, please input your login information");
        }else {
            mvpView.showHome();
        }
    }
}

