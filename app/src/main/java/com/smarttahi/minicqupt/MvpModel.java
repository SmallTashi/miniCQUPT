package com.smarttahi.minicqupt;

import android.content.SharedPreferences;

import com.smarttahi.minicqupt.tools.Config;
import com.smarttahi.minicqupt.tools.HttpRequest;
import com.smarttahi.minicqupt.tools.PackParameter;

import org.json.JSONException;

public class MvpModel {
    private Contract.MvpCallBack callBack;
    private int state;

    MvpModel(Contract.MvpCallBack callBack) {
        this.callBack = callBack;
    }

    public void check(String stuNum, String idNum) {
        checkLoginMessage(stuNum, idNum);
    }


    private void checkLoginMessage(final String stuNum, String idNum) {
        HttpRequest.sentHttpsRequest(PackParameter.User_Key(stuNum, idNum), Config.Api_User_Check, new HttpRequest.Callback() {
                    @Override
                    public void onSuccess(HttpRequest.Response response) {
                        state = response.getState();
                        if (state == 200) {
                            callBack.onSuccess(response.getDate());

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


