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

public class ViewHolderPool extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView mine_item_content;
    public ImageView mine_item_icon;


    public TextView question_item_title;
    public TextView question_item_kind;
    public TextView question_item_detail;
//    public LinearLayout question_item_top;
//    public ImageView question_mine_head;
    public TextView question_idName;
    public TextView question_time_least;
    public TextView question_item_pay;

    public ViewHolderPool(View itemView, int Type) {
        super(itemView);
        itemView.setOnClickListener(this);
        if (Type == MyApplication.QUESTION_LIST) {
            initQuestionItem(itemView);
        } else if (Type == MyApplication.ANSWER_LIST) {
            initAnswerItem(itemView);
        }else if(Type == MyApplication.ANSWER_DETAIL){
            initDetailAnswer(itemView);
        }
        else {
            initMineItem(itemView);
        }
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

    @Override
    public void onClick(View v) {
        //TODO v

    }
}
