package com.smarttahi.minicqupt.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.smarttahi.minicqupt.Data.Question;
import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.dummy.DummyContent;
import com.smarttahi.minicqupt.fragment.CourseFragment;
import com.smarttahi.minicqupt.fragment.FindFragment;
import com.smarttahi.minicqupt.fragment.MineFragment;
import com.smarttahi.minicqupt.fragment.QuestionFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener,QuestionFragment.OnListFragmentInteractionListener {
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
        mine = findViewById(R.id.bottom_mine);
        find = findViewById(R.id.bottom_find);
        course = findViewById(R.id.bottom_course_base);
        question = findViewById(R.id.bottom_question);
        course.setOnClickListener(this);
        find.setOnClickListener(this);
        question.setOnClickListener(this);
        mine.setOnClickListener(this);
        switchFragment(questionFragment);
    }



    private void switchFragment(Fragment addFragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_fragment,addFragment);
        transaction.commit();
    }



    @Override
    public void onClick(View v) {
        if (v==course){
            switchFragment(this.courseFragment);
        }
        if(v==question){
            switchFragment(this.questionFragment);

        }
        if(v==find){
            switchFragment(this.findFragment);
        }
        if(v==mine){
         switchFragment(this.mineFragment);
        }
    }

    @Override
    public void onListFragmentInteraction(Question item) {

    }
}
