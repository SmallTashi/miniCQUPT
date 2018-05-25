package com.smarttahi.minicqupt.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.smarttahi.minicqupt.R;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    TextView title ;
    private RadioGroup group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bottom);
        title = findViewById(R.id.title);
        title.setText("登 陆");
        findViewById(R.id.bottom_group);
        group.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.bottom_time_table:
                //TODO code logic

                break;
            case R.id.bottom_question:
                //TODO code logic

                break;
            case R.id.bottom_find:
                //TODO code logic

                break;
            case R.id.bottom_mine:
                //TODO code logic

                break;
        }
    }
}
