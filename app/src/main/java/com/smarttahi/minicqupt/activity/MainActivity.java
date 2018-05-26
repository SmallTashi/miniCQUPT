package com.smarttahi.minicqupt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.tools.ChangeUnit;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    RadioButton course;
    RadioButton question;
    RadioButton find;
    RadioButton mine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle();
        course = new RadioButton(this);
        question = new RadioButton(this);
        find = new RadioButton(this);
        mine = new RadioButton(this);
        course.findViewById(R.id.bottom_course_base);
        question.findViewById(R.id.bottom_question);
        find.findViewById(R.id.bottom_find);
        mine.findViewById(R.id.bottom_mine);
        course.setOnClickListener(this);
        find.setOnClickListener(this);
        question.setOnClickListener(this);
        mine.setOnClickListener(this);
    }


    @Override
    void setTitle() {
        TopTitle = findViewById(R.id.title);
        Top = findViewById(R.id.top_title);
        Top.setMinimumWidth(ChangeUnit.pt2dp(this, 375));
        Top.setMinimumHeight(ChangeUnit.pt2dp(this, 65));
        TopTitle.setText("登 陆");

    }

    private void replaceFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_course_base:
                //TODO code logic

                break;
            case R.id.bottom_question:
                //TODO code logic

                break;
            case R.id.bottom_find:
                //TODO code logic

                break;
            case R.id.bottom_mine:

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
