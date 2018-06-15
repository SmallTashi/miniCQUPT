package com.smarttahi.minicqupt;

import android.content.SharedPreferences;

import com.smarttahi.minicqupt.Data.User;
import com.smarttahi.minicqupt.tools.Config;
import com.smarttahi.minicqupt.tools.HttpRequest;
import com.smarttahi.minicqupt.tools.JSONmanager;
import com.smarttahi.minicqupt.tools.PackParameter;

import org.json.JSONException;

public class MvpModel {
    private Contract.MvpCallBack callBack;
    private int state;
    private String s=null;

    MvpModel(Contract.MvpCallBack callBack) {
        this.callBack = callBack;
    }

    public void check(String stuNum, String idNum) {
        checkLoginMessage(stuNum, idNum);
    }


    private void checkLoginMessage(final String stuNum, final String idNum) {
        HttpRequest.sentHttpsRequest(PackParameter.User_Key(stuNum, idNum),
                Config.Api_User_Check, new HttpRequest.Callback() {
                    @Override
                    public void onSuccess(HttpRequest.Response response) {
                        state = response.getState();
                        s=response.getDate();
                        if (state == 200&&s!=null) {
                            HttpRequest.sentHttpsRequest(PackParameter.User_Key(stuNum, idNum),
                                    Config.Api_User_Detail, new HttpRequest.Callback() {
                                        @Override
                                        public void onSuccess(HttpRequest.Response response) {
                                            callBack.onSuccess(s,response.getDate());
                                        }

                                        @Override
                                        public void onFiled(Exception e) {
                                            callBack.onError(e.toString());
                                        }
                                    });

                        } else {
                            callBack.onFailed();
                        }
                    }

                    @Override
                    public void onFiled(Exception e) {
                        callBack.onError(e.toString());
                    }
                }
        );
    }

}


