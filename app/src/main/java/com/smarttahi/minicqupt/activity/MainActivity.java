package com.smarttahi.minicqupt.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.smarttahi.minicqupt.R;

public class MainActivity extends AppCompatActivity {
    TextView title ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bottom);
        title = findViewById(R.id.title);
        title.setText("登 陆");
    }
}
