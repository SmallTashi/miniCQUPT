package com.smarttahi.minicqupt.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.tools.ChangeUnit;
import com.smarttahi.minicqupt.tools.MyApplication;

public class QuestionFragment extends Fragment {
    TextView textView;
    LinearLayout question_kind_layout;
    TextView question_kind;
    TextView question_item_pay;
    TextView question_item_detail;

    public TextView question_item_title;
    public TextView question_item_kind;
    public LinearLayout question_item_top;
    public ImageView question_mine_head;
    public TextView question_idName;
    public TextView question_time_least;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        question_item_pay.findViewById(R.id.question_item_pay);
//        question_item_pay.setTextSize(ChangeUnit.pt2sp(MyApplication.getThisContext(), 12));
//        question_item_pay.setCompoundDrawablePadding(ChangeUnit.pt2dp(MyApplication.getThisContext(), 4));

//        question_kind_layout.findViewById(R.id.question_item_lay_kind);
//        question_kind_layout.setMinimumHeight(ChangeUnit.pt2dp(MyApplication.getThisContext(), 13));
//        question_kind_layout.setMinimumWidth(ChangeUnit.pt2dp(MyApplication.getThisContext(), 47));
//        question_item_detail.findViewById(R.id.question_item_detail);
//        question_item_detail.setMinimumHeight(ChangeUnit.pt2dp(MyApplication.getThisContext(), 307));
    }


}
