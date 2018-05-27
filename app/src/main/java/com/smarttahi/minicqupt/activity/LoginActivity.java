package com.smarttahi.minicqupt.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import java.util.Arrays;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    public EditText idNum;
    TextView TopTitle;
    ImageView Left;
    ImageView Right;
    RelativeLayout Top;
    public EditText stuNum;
    public CardView login_card;
    public Button login ;
    public static int state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        setTitle("登 陆");
        this.login = new Button(this);
        this.login = findViewById(R.id.login_button);
        this.stuNum = new EditText(this);
        this.stuNum = findViewById(R.id.login_stuNum);
        this.idNum = new EditText(this);
        this.idNum = findViewById(R.id.login_idNum);
        this.login_card = new CardView(this);
        this.login_card = findViewById(R.id.login_card);
        login.setOnClickListener(this);
        login_card.setMinimumHeight(ChangeUnit.pt2dp(MyApplication.getThisContext(), 225));
        login_card.setMinimumWidth(ChangeUnit.pt2dp(MyApplication.getThisContext(), 323));
        TopTitle = findViewById(R.id.title);
        Top = findViewById(R.id.top_title);
        Left = findViewById(R.id.top_title_left);
        Right = findViewById(R.id.top_title_right);
        setTitle(Left,Right,Top,TopTitle,"登 陆");
    }

    void setTitle(
            ImageView Left,
            ImageView Right,
            RelativeLayout Top, TextView TopTitle, String s) {
        Left.setImageResource(R.mipmap.course_back);
        Left.setVisibility(View.VISIBLE);
        Right.setVisibility(View.INVISIBLE);

        Top.setMinimumWidth(ChangeUnit.pt2dp(this, 375));
        Top.setMinimumHeight(ChangeUnit.pt2dp(this, 65));
        TopTitle.setText(s);
        }

        @Override
        public void onClick(View v) {
            if (v == login) {
                String idNum;
            String stuNum;
            idNum = this.idNum.getText().toString();
            stuNum = this.stuNum.getText().toString();
            if(idNum.equals("") || stuNum.equals("")){
                addToast("请完善登陆信息",false);
            }else if (stuNum.length()==10&&idNum.length()==6) {

                checkLoginMessage(stuNum,idNum);
            }
        } else {
            addToast("瞎点啥呐，讨厌...", true);
        }
    }


    public void addToast(String s, boolean Short) {
        if (Short) {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        }
    }

    public void checkLoginMessage(final String stuNum, String idNum) {
        if(stuNum!=null&&idNum!=null){
            HttpRequest.sentHttpsRequest(PackParameter.User_Key(stuNum, idNum), Config.Api_User_Check, new HttpRequest.Callback() {
                        @Override
                        public void onSuccess(HttpRequest.Response response) throws JSONException {
                            state = response.getState();
//                            addToast(response.getDate(), false);
                            addToast("请稍后...",false);
                            final User checkUser;
                            if (state == 801) {
                                addToast("学号或密码错误，请重新输入", false);
                            } else{
                               checkUser = JSONmanager.checkUser(response.getDate());
                                MyApplication.setUser(checkUser);
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }


                        @Override
                        public void onSuccess(ArrayList<?> response) throws JSONException {
//                            addToast("", true);
                        }

                        @Override
                        public void onFiled(Exception e) {
                            addToast(e.toString(), false);
                        }
                    }
            );
        }else {
            addToast("信息错误",false);
        }



    }

    private void keepState(User user) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String stuNum = user.getStuNum();
        String idNum = user.getIdNum();
        int userId = user.getId();
        String stuName = user.getName();
        String gender = user.getGender();
        editor.apply();
        editor.commit();

    }

}
