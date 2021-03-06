package com.sibo.fastsport.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sibo.fastsport.R;
import com.sibo.fastsport.listener.OnItemClickListener;

import java.util.List;

/**
 * Created by chuan on 2017/3/25.
 */

public class LabelAdapter extends RecyclerView.Adapter<LabelAdapter.MyViewHolder> {
    private Context context;
    private List<String> list;
    private OnItemClickListener onItemClickListener;
    private int pos = -1;

    public LabelAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_label, null), onItemClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (list.size() - 1 == position) {
            holder.detele.setVisibility(View.GONE);
        } else {
            holder.detele.setVisibility(View.VISIBLE);
        }
        holder.label.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        if (list == null || list.size() == 0) {
            return 0;
        }
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView label;
        private ImageView detele;
        private OnItemClickListener onItemClickListener;

        public MyViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.onItemClickListener = onItemClickListener;
            label = (TextView) itemView.findViewById(R.id.tv_label);
            detele = (ImageView) itemView.findViewById(R.id.delete);
            detele.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(getAdapterPosition());
            }
        }
    }
}
