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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.activity.LoginActivity;
import com.smarttahi.minicqupt.tools.ChangeUnit;
import com.smarttahi.minicqupt.tools.MyApplication;

public class MineFragment extends Fragment {
    private String nickname ;
    private String introduction;
    TextView TopTitle;
    ImageView Left;
    TextView Right;
    RelativeLayout Top;
    private EditText Nickname;
    private EditText Introduction;

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
        TopTitle = view.findViewById(R.id.title);
        Top = view.findViewById(R.id.top_title);
        Right = new TextView(MyApplication.getThisContext());
        Right = view.findViewById(R.id.top_title_right_text);

        Right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyApplication.getThisContext(), LoginActivity.class);
                startActivity(intent);

            }
        });
        Left = view.findViewById(R.id.top_title_left);
        setTitle(Left,Right,Top, TopTitle,"我 的");
        Nickname =  new EditText(MyApplication.getThisContext());
        Introduction = new EditText(MyApplication.getThisContext());
        if(MyApplication.getUser()!=null){
            Nickname.setText(MyApplication.getUser().getNickname());
        }
    }

}
