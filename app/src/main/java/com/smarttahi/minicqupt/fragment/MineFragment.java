package com.smarttahi.minicqupt.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.tools.ChangeUnit;
import com.smarttahi.minicqupt.tools.MyApplication;

import java.util.ArrayList;

public class MineFragment extends Fragment {
    private ArrayList<String> question_id;
    private ArrayList<String> question_title;
    private ArrayList<String> question_time;
    private ArrayList<String> question_pay;
    private ArrayList<String> question_kind;
    private ArrayList<Integer> question_content;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

}
