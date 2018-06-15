package com.smarttahi.minicqupt.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smarttahi.minicqupt.Data.User;
import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.activity.LoginActivity;
import com.smarttahi.minicqupt.tools.ChangeUnit;
import com.smarttahi.minicqupt.tools.MyApplication;

public class MineFragment extends Fragment {
    public TextView TopTitle;
    public ImageView Left;
    public TextView Right;
    public RelativeLayout Top;
    public ImageButton RightButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine_list, container, false);
    }
    void setTitle(ImageView Left, TextView Right, RelativeLayout Top, TextView TopTitle, String s) {
        Left.setImageResource(R.mipmap.course_back);
        Left.setVisibility(View.VISIBLE);
        Right.setText("登 陆");
        Right.setVisibility(View.VISIBLE);
        Top.setMinimumWidth(ChangeUnit.pt2dp(MyApplication.getThisContext(), 375));
        Top.setMinimumHeight(ChangeUnit.pt2dp(MyApplication.getThisContext(), 65));
        TopTitle.setText(s);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TopTitle = view.findViewById(R.id.top_title_center_text);
        Top = view.findViewById(R.id.top_bar);
        Right = new TextView(MyApplication.getThisContext());
        Right = view.findViewById(R.id.top_title_right_text);
        Left = view.findViewById(R.id.top_title_left_back);

        Left.setImageResource(R.mipmap.course_back);
        Left.setVisibility(View.VISIBLE);
        Right.setText("登 陆");
        Right.setVisibility(View.VISIBLE);
        Top.setMinimumWidth(ChangeUnit.pt2dp(MyApplication.getThisContext(), 375));
        Top.setMinimumHeight(ChangeUnit.pt2dp(MyApplication.getThisContext(), 65));
        TopTitle.setText("我 的");
        Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyApplication.getThisContext(), LoginActivity.class);
                startActivity(intent);

            }
        });
        EditText nickname = new EditText(MyApplication.getThisContext());
        EditText introduction = new EditText(MyApplication.getThisContext());
        User user = MyApplication.getUser();
        if(user!=null){
            nickname.setText( user.getNickname());

            introduction.setText(user.getIntroduction());
        }
    }

}
