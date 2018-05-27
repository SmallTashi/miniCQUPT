package com.smarttahi.minicqupt.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smarttahi.minicqupt.Data.Question;
import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.adapter.MyListAdapter;
import com.smarttahi.minicqupt.tools.ChangeUnit;
import com.smarttahi.minicqupt.tools.Config;
import com.smarttahi.minicqupt.tools.HttpRequest;
import com.smarttahi.minicqupt.tools.JSONmanager;
import com.smarttahi.minicqupt.tools.MyApplication;
import com.smarttahi.minicqupt.tools.PackParameter;

import org.json.JSONException;

import java.util.ArrayList;

public class QuestionFragment extends Fragment {
    TextView textView;
    LinearLayout question_kind_layout;
    TextView question_kind;
    TextView question_item_pay;
    TextView question_item_detail;

    TextView TopTitle;
    ImageView Left;
    ImageView Right;
    TextView RightText;
    RelativeLayout Top;

    ArrayList<Question.QuestionDataBean> list;
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> time = new ArrayList<>();
    ArrayList<String> kind = new ArrayList<>();
    ArrayList<String> detail = new ArrayList<>();
    //    ArrayList<Bitmap> head= new ArrayList<>();
    ArrayList<String> pay = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();


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
        question_item_title = view.findViewById(R.id.question_item_title);

        HttpRequest.sentHttpsRequest(PackParameter.Question_List(1, "其他"), Config.Api_Question_List, new HttpRequest.Callback() {
            @Override
            public void onSuccess(HttpRequest.Response response) throws JSONException {
                list = JSONmanager.getQuestionList(response.getDate());
                for (int i = 0; i < 6; i++) {
                    addToast(String.valueOf(list.get(i)),false);
                    title.add(i, list.get(i).getTitle());
                    detail.add(i, list.get(i).getDescription());
                    kind.add(i, list.get(i).getKind());
                    pay.add(i, String.valueOf(list.get(i).getReward()));
                    time.add(i, list.get(i).getDisappear_at());
                    id.add(i, String.valueOf(list.get(i).getId()));
//                    head.add(i,list.get(i).getPhoto_thumbnail_src().);
                }
            }

            @Override
            public void onFiled(Exception e) {
                addToast("请求数据失败", true);
            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.question_list);
        LinearLayoutManager manager = new LinearLayoutManager(MyApplication.getThisContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        MyListAdapter adapter = new MyListAdapter(title, detail, pay, time, id, kind, MyApplication.QUESTION_LIST);
        recyclerView.setAdapter(adapter);
        TopTitle = view.findViewById(R.id.title);
        Top = view.findViewById(R.id.top_title);
        RightText = view.findViewById(R.id.top_title_right_text);

        Left = view.findViewById(R.id.top_title_left);
        Right = view.findViewById(R.id.top_title_right);
        Left.setImageResource(R.mipmap.question_ring);
        Left.setVisibility(View.VISIBLE);
        RightText.setVisibility(View.INVISIBLE);
        Right.setVisibility(View.INVISIBLE);
        TopTitle.setText("邮 问");


    }


    public void addToast(String s, boolean Short) {
        if (Short) {
            Toast.makeText(MyApplication.getThisContext(), s, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MyApplication.getThisContext(), s, Toast.LENGTH_LONG).show();
        }
    }
}
