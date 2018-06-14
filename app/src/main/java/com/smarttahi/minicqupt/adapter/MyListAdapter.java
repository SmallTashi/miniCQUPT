package com.smarttahi.minicqupt.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarttahi.minicqupt.Data.Question;
import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.ViewHolder.ViewHolderPool;
import com.smarttahi.minicqupt.tools.MyApplication;

import java.util.ArrayList;
import java.util.List;


public class MyListAdapter extends RecyclerView.Adapter<ViewHolderPool> {
    private ArrayList<Integer> image_normal;
    private ArrayList<Integer> image_first;

    private ArrayList<Question> question;
    private OnItemClickLister onItemClickLister = null;
    private int type;

    public MyListAdapter(ArrayList<Question> questionItem,int ItemType){
        type = ItemType;
        question = questionItem;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPool holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    public interface OnItemClickLister{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLister(OnItemClickLister onItemClickLister) {
        this.onItemClickLister = onItemClickLister;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @NonNull
    @Override
    public ViewHolderPool onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (type== MyApplication.QUESTION_LIST) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_fragment_mine_item, parent, false);

        }else if(type == MyApplication.ANSWER_LIST){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_fragment_mine_item,parent,false);
        }
        else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_fragment_mine_item, parent, false);
        }


        return new ViewHolderPool(view,type);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderPool holder, int position) {

        if (type==MyApplication.QUESTION_LIST) {
            holder.question_item_pay.setText(question.get(position).getReward());
            holder.question_idName.setText(question.get(position).id);
            holder.question_item_detail.setText(question.get(position).getDescription());
            holder.question_item_kind.setText(question.get(position).getKind());
            holder.question_item_title.setText(question.get(position).getTitle());
            holder.question_time_least.setText(question.get(position).getDisappear_at());
        }
//        else if(type==MyApplication.ANSWER_LIST){
//            holder.theme_id.setText(question_title.get(0));
//            holder.theme_head.setImageResource(question_content.get(0));
//            holder.theme_share.setImageResource(question_content.get(1));
//            holder.theme_add.setImageResource(question_content.get(2));
//            holder.theme_article_img.setImageResource(question_content.get(3));
//        }
        else {
            holder.mine_item_icon.setImageResource(image_normal.get(position));
//            holder.mine_item_content.setText(question.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return (question.size());
    }




}


