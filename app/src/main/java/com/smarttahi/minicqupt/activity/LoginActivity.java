package com.smarttahi.minicqupt.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smarttahi.minicqupt.Contract;

import com.smarttahi.minicqupt.MvpPresenter;
import com.smarttahi.minicqupt.R;


public class LoginActivity extends BaseActivity implements Contract.MvpView, View.OnClickListener{
    public EditText idNum;
    public EditText stuNum;
    public CardView login_card;
    public Button login;
    private Contract.Presenter presenter;
    public String idNumString;
    public String stuNumString;

    @Override
    public void addToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showHome() {
        Intent intent = new Intent(LoginActivity.this, TestActivity.class);
        startActivity(intent);
        finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        findView();
        setTitle("登 陆");
        presenter = new MvpPresenter(this);
        SharedPreferences preferences = getSharedPreferences("user", MODE_PRIVATE);
        idNumString = preferences.getString("idNum", "");
        stuNumString = preferences.getString("stuNum", "");
        if (!idNumString.equals("") && !stuNumString.equals("")) {
            this.idNum.setText(idNumString);
            this.stuNum.setText(stuNumString);
        }
        login.setOnClickListener(this);
    }




    void findView() {
        this.login = new Button(this);
        this.login = findViewById(R.id.login_button);
        this.stuNum = new EditText(this);
        this.stuNum = findViewById(R.id.login_stuNum);
        this.idNum = new EditText(this);
        this.idNum = findViewById(R.id.login_idNum);
        this.login_card = new CardView(this);
        this.login_card = findViewById(R.id.login_card);
        Left = new ImageButton(this);
        Right = new TextView(this);
        RightButton = new ImageButton(this);
        Left.setVisibility(View.VISIBLE);
        RightButton.setVisibility(View.INVISIBLE);
        Right.setText("登 出");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                idNumString = this.idNum.getText().toString();
                stuNumString = this.stuNum.getText().toString();
                presenter.login(stuNumString, idNumString);
                addToast("Waiting");
                break;
            default:
                break;
        }
    }


}
