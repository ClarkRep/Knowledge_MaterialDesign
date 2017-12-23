package com.example.zhaodanyang.knowledge_materialdesign.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zhaodanyang.knowledge_materialdesign.R;

/**
 * Description
 * Company Beijing icourt
 *
 * @author zhaodanyang  E-mail:zhaodanyang@icourt.cc
 *         date createTime：2017/12/22
 *         version
 */
public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.MyHolder> {

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        MyHolder holder = new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tvName.setText("我是第 " + position + " 个");
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    static class MyHolder extends RecyclerView.ViewHolder {

        public TextView tvName;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
        }

    }
}
