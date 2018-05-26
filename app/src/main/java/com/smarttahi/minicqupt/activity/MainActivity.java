package com.smarttahi.minicqupt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.smarttahi.minicqupt.Data.Question;
import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.fragment.CourseFragment;
import com.smarttahi.minicqupt.fragment.FindFragment;
import com.smarttahi.minicqupt.fragment.MineFragment;
import com.smarttahi.minicqupt.fragment.QuestionFragment;
import com.smarttahi.minicqupt.tools.ChangeUnit;

public class MainActivity extends BaseActivity implements RadioButton.OnCheckedChangeListener {

    RadioGroup bottom;
    CourseFragment courseFragment;
    QuestionFragment questionFragment;
    MineFragment mineFragment;
    FindFragment findFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("本 周");
        courseFragment = new CourseFragment();
        questionFragment = new QuestionFragment();
        mineFragment = new MineFragment();
        findFragment = new FindFragment();
        bottom = (RadioGroup) findViewById(R.id.bottom);
        replaceFragment(courseFragment);
//        bottom.setMinimumHeight(ChangeUnit.pt2dp(this,48));
    }


    @Override
    void setTitle(String s) {
        TopTitle = findViewById(R.id.title);
        Top = findViewById(R.id.top_title);
        Top.setMinimumWidth(ChangeUnit.pt2dp(this, 375));
        Top.setMinimumHeight(ChangeUnit.pt2dp(this, 65));
        TopTitle.setText(s);

    }

    private void replaceFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //第一种获得单选按钮值的方法
        //为radioGroup设置一个监听器:setOnCheckedChanged()
        bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            RadioButton course = findViewById(R.id.bottom_course_base);
            RadioButton question = findViewById(R.id.bottom_question);
            RadioButton find = findViewById(R.id.bottom_find);
            RadioButton mine = findViewById(R.id.bottom_mine);

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.bottom_course_base:
                        //TODO code logic
                        TopTitle.setText("本 周");
                        replaceFragment(courseFragment);
                        break;
                    case R.id.bottom_question:
                        //TODO code logic
                        TopTitle.setText("邮 问");
                        replaceFragment(questionFragment);
                        break;
                    case R.id.bottom_find:
                        //TODO code logic
                        TopTitle.setText("发 现");
                        replaceFragment(findFragment);
                        break;
                    case R.id.bottom_mine:
                        TopTitle.setText("我 的");
                        replaceFragment(mineFragment);
                        break;
                }
            }
        });
    }
}
