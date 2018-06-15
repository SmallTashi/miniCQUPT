package com.smarttahi.minicqupt.ViewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.tools.ChangeUnit;
import com.smarttahi.minicqupt.tools.MyApplication;

import java.util.ArrayList;

public class ViewHolderPool extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView mine_item_content;
    public ImageView mine_item_icon;


    public TextView question_item_title;
    public TextView question_item_kind;
    public TextView question_item_detail;
    public TextView question_idName;
    public TextView question_time_least;
    public TextView question_item_pay;

    public TextView content;
    public ImageView imageView_normal;
    public ViewHolderPool(View itemView) {
        super(itemView);
        initNormal(itemView);
    }

    private void initDetailAnswer(View itemView) {

    }

    private void initAnswerItem(View itemView) {

    }

    private void initQuestionItem(View itemView) {
        question_item_pay = itemView.findViewById(R.id.question_item_pay);
        question_item_title = itemView.findViewById(R.id.question_item_title);
        question_item_kind = itemView.findViewById(R.id.question_item_kind);
        question_item_detail = itemView.findViewById(R.id.question_item_detail);
//        question_mine_head = itemView.findViewById(R.id.question_mine_head);
        question_idName = itemView.findViewById(R.id.question_idName);
        question_time_least = itemView.findViewById(R.id.answer_time);
        CardView cardView = itemView.findViewById(R.id.question_card);
        cardView.setRadius(ChangeUnit.pt2dp(MyApplication.getThisContext(),6));
    }

    private void initMineItem(View itemView) {
        mine_item_icon = itemView.findViewById(R.id.mine_item_icon);
        mine_item_content = itemView.findViewById(R.id.mine_item_content);
    }

    void initNormal(View itemView) {
        CardView cardView = itemView.findViewById(R.id.item_view);
        cardView.setCardElevation(5);
        cardView.setCardBackgroundColor(itemView.getResources().getColor(R.color.colorAccent));
        imageView_normal = itemView.findViewById(R.id.image);
        content = itemView.findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        //TODO v

    }
}
