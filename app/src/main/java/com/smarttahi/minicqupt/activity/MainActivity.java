package com.smarttahi.minicqupt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.smarttahi.minicqupt.Data.User;
import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.fragment.CourseFragment;
import com.smarttahi.minicqupt.fragment.FindFragment;
import com.smarttahi.minicqupt.fragment.MineFragment;
import com.smarttahi.minicqupt.fragment.QuestionFragment;
import com.smarttahi.minicqupt.tools.Config;
import com.smarttahi.minicqupt.tools.HttpRequest;
import com.smarttahi.minicqupt.tools.JSONmanager;
import com.smarttahi.minicqupt.tools.MyApplication;
import com.smarttahi.minicqupt.tools.PackParameter;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    CourseFragment courseFragment = new CourseFragment();
    QuestionFragment questionFragment = new QuestionFragment();
    MineFragment mineFragment = new MineFragment();
    FindFragment findFragment = new FindFragment();
    RadioButton course;
    RadioButton question;
    RadioButton find;
    RadioButton mine;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        course = new RadioButton(this);
        mine = new RadioButton(this);
        find = new RadioButton(this);
        question = new RadioButton(this);

        replaceFragment(courseFragment);
        mine = (RadioButton) findViewById(R.id.bottom_mine);
        find = (RadioButton)findViewById(R.id.bottom_find);
        course = (RadioButton)findViewById(R.id.bottom_course_base);
        question =(RadioButton) findViewById(R.id.bottom_question);
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(mineFragment);
            }
        });
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(questionFragment);
            }
        });
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(courseFragment);
            }
        });
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(findFragment);
            }
        });
    }

private void UserMessage(User checkUser){
    HttpRequest.sentHttpsRequest(PackParameter.User_Key(checkUser.getStuNum(), checkUser.getIdNum()), Config.Api_User_Detail, new HttpRequest.Callback() {
        @Override
        public void onSuccess(HttpRequest.Response response) throws JSONException {
            User add;
            add = JSONmanager.getUser(response.getDate(),MyApplication.getUser());
            MyApplication.setUser(add);
        }

        @Override
        public void onSuccess(ArrayList<?> response) throws JSONException {

        }

        @Override
        public void onFiled(Exception e) {

        }
    });

}

    private void replaceFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_fragment, fragment);
        transaction.commit();
    }

}
