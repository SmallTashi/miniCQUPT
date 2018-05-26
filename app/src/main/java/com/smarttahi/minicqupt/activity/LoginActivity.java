package com.smarttahi.minicqupt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smarttahi.minicqupt.Data.User;
import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.tools.ChangeUnit;
import com.smarttahi.minicqupt.tools.Config;
import com.smarttahi.minicqupt.tools.HttpRequest;
import com.smarttahi.minicqupt.tools.JSONmanager;
import com.smarttahi.minicqupt.tools.MyApplication;
import com.smarttahi.minicqupt.tools.PackParameter;

import org.json.JSONException;

import java.util.ArrayList;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    public EditText idNum;
    public EditText stuNum;
    public CardView login_card;
    public Button login;
    public static int state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
    }

    void setTitle(String s) {
        TopTitle = findViewById(R.id.title);
        Top = findViewById(R.id.top_title);
        Top.setMinimumWidth(ChangeUnit.pt2dp(this,375));
        Top.setMinimumHeight(ChangeUnit.pt2dp(this,65));
        TopTitle.setText(s);
    }

    @Override
    public void onClick(View v) {
     if (v == login) {
            String username;
            String pwd;
            username = idNum.getText().toString();
            pwd = stuNum.getText().toString();
            if (BaseActivity.isLengthLegal(username,10)&&BaseActivity.isLengthLegal(pwd,6)) {
                checkLoginMessage(username, pwd);
            }
        }
        else{
            addToast("瞎点啥呐，讨厌...",true);
        }
    }

    public void findViews() {
        this.login = findViewById(R.id.login_button);
        this.stuNum = findViewById(R.id.login_stuNum);
        this.idNum = findViewById(R.id.login_idNum);
        this.login_card = findViewById(R.id.login_card);
    }
    public void addToast(String s, boolean Short){
        if(Short){
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();
        }
    }

    public void checkLoginMessage(final String stuNum, String idNum) {
        int s = Integer.getInteger(stuNum);
        int i = Integer.getInteger(idNum);
        HttpRequest.sentHttpRequest(PackParameter.User_Key(s, i), Config.Api_User_Check, new HttpRequest.Callback() {
            @Override
            public void onSuccess(HttpRequest.Response response) throws JSONException {
                state = response.getState();
                int s = response.getState();
                User user;
                if(s==801){
                    addToast("学号或密码错误，请重新输入",false);
                }
                else if(s!=200){
                    addToast("未知错误",false);
                }
                else {
                    JSONmanager.getUser(response.getInfo());
                    user = MyApplication.getUser();
                    MyApplication.setUser(user);
//                    Bundle bundle = new Bundle();
//                    bundle.putParcelable("user",user);
//                    PersonalFragment personalFragment = new PersonalFragment();
//                    personalFragment.setArguments(bundle);
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onSuccess(ArrayList<?> response) throws JSONException {

            }

            @Override
            public void onFiled(Exception e) {

            }
        });
    }

}
