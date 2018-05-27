package com.smarttahi.minicqupt.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

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

        replaceFragment(questionFragment);
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



    private void replaceFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_fragment, fragment);
        transaction.commit();
    }

}
