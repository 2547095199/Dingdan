package com.example.cz.lianxiyuekao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.lianxiyuekao.R;
import com.example.cz.lianxiyuekao.bean.TheorderBean;
import com.example.cz.lianxiyuekao.bean.UpdateBean;
import com.example.cz.lianxiyuekao.persenter.UpdatePersenter;
import com.example.cz.lianxiyuekao.view.UpdateView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZ on 2018/1/16.
 */

public class TheorderAdapter extends RecyclerView.Adapter<TheorderAdapter.MyViewHolder> implements UpdateView {
    Context context;
    List<TheorderBean.DataBean> list;
    UpdatePersenter persenter = new UpdatePersenter(this);

    public TheorderAdapter(Context context, List<TheorderBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_theorderadapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.price.setText("价格:" + list.get(position).getPrice());
        holder.time.setText("创建时间:" + list.get(position).getCreatetime());
        if (list.get(position).getStatus() == 0) {
            holder.stats.setText("待支付");
            holder.button.setText("取消订单");
        } else if (list.get(position).getStatus() == 1) {
            holder.stats.setText("已支付");
            holder.button.setText("查看订单");
        } else if (list.get(position).getStatus() == 2) {
            holder.stats.setText("已取消");
            holder.button.setText("查看订单");
        }
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(position).getStatus() == 0) {
                    holder.stats.setText("已取消");
                    holder.button.setText("查看订单");
                    persenter.getData("100", "2", list.get(position).getOrderid() + "", "android");
                    notifyDataSetChanged();
                } else if (list.get(position).getStatus() == 1) {
                    Toast.makeText(context, "已支付", Toast.LENGTH_SHORT).show();
                } else if (list.get(position).getStatus() == 2) {
                    Toast.makeText(context, "已取消", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void success(UpdateBean bean) {
        Toast.makeText(context, bean.getMsg() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(context, "错误", Toast.LENGTH_SHORT).show();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.stats)
        TextView stats;
        @BindView(R.id.button)
        Button button;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
