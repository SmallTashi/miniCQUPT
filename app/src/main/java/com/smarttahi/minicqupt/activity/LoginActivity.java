package com.smarttahi.minicqupt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smarttahi.minicqupt.Contract;

import com.smarttahi.minicqupt.MvpPresenter;
import com.smarttahi.minicqupt.R;


public class LoginActivity extends BaseActivity implements Contract.MvpView, View.OnClickListener {
    public EditText idNum;
    TextView TopTitle;
    ImageView Left;
    ImageView Right;
    public EditText stuNum;
    public CardView login_card;
    public Button login;
    private Contract.Presenter presenter;

    @Override
    public void addToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showHome() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        findView();
        TopTitle = findViewById(R.id.title);
        Left = findViewById(R.id.top_title_left);
        Right = findViewById(R.id.top_title_right);
        setTitle(Left, Right, TopTitle, "登 陆");
        presenter = new MvpPresenter(this);
        presenter.checkState();
        login.setOnClickListener(this);
    }


    void findView() {
        setTitle("登 陆");
        this.login = new Button(this);
        this.login = findViewById(R.id.login_button);
        this.stuNum = new EditText(this);
        this.stuNum = findViewById(R.id.login_stuNum);
        this.idNum = new EditText(this);
        this.idNum = findViewById(R.id.login_idNum);
        this.login_card = new CardView(this);
        this.login_card = findViewById(R.id.login_card);
    }


    void setTitle(ImageView Left, ImageView Right, TextView TopTitle, String s) {
        Left.setImageResource(R.mipmap.course_back);
        Left.setVisibility(View.VISIBLE);
        Right.setVisibility(View.INVISIBLE);
        TopTitle.setText(s);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                String idNum;
                String stuNum;
                idNum = this.idNum.getText().toString();
                stuNum = this.stuNum.getText().toString();
                presenter.login(stuNum, idNum);

                break;
            default:
                break;
        }
    }
}
