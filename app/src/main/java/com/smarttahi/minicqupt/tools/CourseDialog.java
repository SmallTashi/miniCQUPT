package com.smarttahi.minicqupt.tools;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.smarttahi.minicqupt.R;

public class CourseDialog extends AlertDialog {


    private int layoutResource;
    private Context context;

    CourseDialog(Context context, int layout) {
        super(context);
        this.layoutResource = layout;
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.layoutResource);
        Builder builder = new Builder(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setView(R.layout.dialog_course);
        }else {
            builder.setView(findViewById(R.id.course_name));
            builder.setView(findViewById(R.id.course_teacher));
            builder.setView(findViewById(R.id.course_location));
            builder.setView(findViewById(R.id.course_time));
            builder.setView(findViewById(R.id.course_type));
            builder.setView(findViewById(R.id.course_week));

        }
        builder.create();
        builder.show();
    }
}

