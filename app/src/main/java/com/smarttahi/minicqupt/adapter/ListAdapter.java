package com.smarttahi.minicqupt.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarttahi.minicqupt.R;
import com.smarttahi.minicqupt.ViewHolder.ViewHolderPool;
import com.smarttahi.minicqupt.tools.MyApplication;

import java.util.ArrayList;
import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ViewHolderPool> {
    private ArrayList<Integer> image_normal;
    private ArrayList<Integer> image_first;

    private ArrayList<String> question_id;
    private ArrayList<String> question_title;
    private ArrayList<String> question_time;
    private ArrayList<String> question_pay;
    private ArrayList<String> question_kind;
    private ArrayList<Integer> question_content;
    private OnItemClickLister onItemClickLister = null;
    private int type=-1;


    @Override
    public void onBindViewHolder(@NonNull ViewHolderPool holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    public static interface OnItemClickLister{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLister(OnItemClickLister onItemClickLister) {
        this.onItemClickLister = onItemClickLister;
    }

    public ListAdapter(ArrayList<Integer> image_normal, ArrayList<String> texts_normal, int ItemType) {
        this.image_normal = image_normal;
        this.image_first = new ArrayList<>();
        this.question_id = texts_normal;
        this.question_title = new ArrayList<>();
        this.question_content = new ArrayList<>();
        type = ItemType;

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
            holder.question_item_pay.setText(question_pay.get(position));
            holder.question_mine_head.setImageResource(image_first.get(position));
            holder.question_idName.setText(question_id.get(position));
            holder.question_item_detail.setText(question_content.get(position));
            holder.question_item_kind.setText(question_kind.get(position));
            holder.question_time_least.setText(question_time.get(position));
        }else if(type==MyApplication.ANSWER_LIST){
//            holder.theme_id.setText(question_title.get(0));
//            holder.theme_head.setImageResource(question_content.get(0));
//            holder.theme_share.setImageResource(question_content.get(1));
//            holder.theme_add.setImageResource(question_content.get(2));
//            holder.theme_article_img.setImageResource(question_content.get(3));
        }
        else {
            holder.mine_item_icon.setImageResource(image_normal.get(position));
            holder.mine_item_content.setText(question_id.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return (question_id.size());
    }




}


