package com.example.cz.lianxiyuekao.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cz.lianxiyuekao.R;
import com.example.cz.lianxiyuekao.bean.LieBIaoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZ on 2018/1/11.
 */

public class LieBiaoAdapter extends RecyclerView.Adapter<LieBiaoAdapter.MyViewHolder> {
    List<LieBIaoBean.DataBean> list;
    Context context;

    public LieBiaoAdapter(List<LieBIaoBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_liebiaoadapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        String[] split = list.get(position).getImages().split("\\|");
        holder.simple.setImageURI(Uri.parse(split[0]));
        holder.price.setText("￥：" + list.get(position).getPrice());
        holder.title.setText(list.get(position).getTitle());
        if (mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simple)
        SimpleDraweeView simple;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.title)
        TextView title;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
