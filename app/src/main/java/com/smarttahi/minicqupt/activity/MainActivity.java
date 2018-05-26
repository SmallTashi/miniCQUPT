package com.smarttahi.minicqupt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.smarttahi.minicqupt.Data.Question;
import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.fragment.CourseFragment;
import com.smarttahi.minicqupt.fragment.FindFragment;
import com.smarttahi.minicqupt.fragment.MineFragment;
import com.smarttahi.minicqupt.fragment.QuestionFragment;
import com.smarttahi.minicqupt.tools.ChangeUnit;

public class MainActivity extends BaseActivity {

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
        bottom = findViewById(R.id.bottom);
        replaceFragment(courseFragment);
//        bottom.setMinimumHeight(ChangeUnit.pt2dp(this,48));

        bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.bottom_course_base:
                        //TODO code logic
                        replaceFragment(courseFragment);
                        break;
                    case R.id.bottom_question:
                        //TODO code logic
                        replaceFragment(questionFragment);
                        break;
                    case R.id.bottom_find:
                        //TODO code logic
                        replaceFragment(findFragment);
                        break;
                    case R.id.bottom_mine:
                        replaceFragment(mineFragment);
                        break;
                }
            }
        });
    }



    private void replaceFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_fragment, fragment);
        transaction.commit();
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.bottom_course_base:
//                //TODO code logic
//                replaceFragment(courseFragment);
//                break;
//            case R.id.bottom_question:
//                //TODO code logic
//                replaceFragment(questionFragment);
//                break;
//            case R.id.bottom_find:
//                //TODO code logic
//                replaceFragment(findFragment);
//                break;
//            case R.id.bottom_mine:
//                replaceFragment(mineFragment);
//                break;
//        }
//    }
}
