package com.example.cz.lianxiyuekao.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.lianxiyuekao.R;
import com.example.cz.lianxiyuekao.bean.DeleteBean;
import com.example.cz.lianxiyuekao.bean.GengXinBean;
import com.example.cz.lianxiyuekao.bean.GoWuCheBean;
import com.example.cz.lianxiyuekao.persenter.DeletePersenter;
import com.example.cz.lianxiyuekao.persenter.GengXinPersenter;
import com.example.cz.lianxiyuekao.view.CustCrom;
import com.example.cz.lianxiyuekao.view.DeleteView;
import com.example.cz.lianxiyuekao.view.GengXInView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CZ on 2018/1/15.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements DeleteView, GengXInView {
    Context context;
    List<GoWuCheBean.DataBean.ListBean> list;

    List<String> shuju = new ArrayList<>();

    HashMap<String, String> map = new HashMap<>();

    private List<GoWuCheBean.DataBean.ListBean> first;
    DeletePersenter persenter = new DeletePersenter(this);
    GengXinPersenter persenter2 = new GengXinPersenter(this);

    public MyAdapter(Context context) {
        this.context = context;
    }

    public void add(GoWuCheBean bean) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        for (GoWuCheBean.DataBean shop : bean.getData()) {
            map.put(shop.getSellerid(), shop.getSellerName());
            for (int i = 0; i < shop.getList().size(); i++) {
                this.list.add(shop.getList().get(i));
            }
        }
        setFirst(this.list);
        notifyDataSetChanged();
    }

    public void setFirst(List<GoWuCheBean.DataBean.ListBean> first) {
        if (list.size() > 0) {
            list.get(0).setIsFirst(1);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getSellerid() == list.get(i - 1).getSellerid()) {
                    list.get(i).setIsFirst(2);
                } else {
                    list.get(i).setIsFirst(1);
                }
            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gowucheadapter, null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (list.get(position).getIsFirst() == 1) {
            holder.shangCheckbox.setChecked(list.get(position).isShopSelected());
            holder.shangjia.setVisibility(View.VISIBLE);
            holder.shangCheckbox.setChecked(list.get(position).isShopSelected());
            holder.shangjia.setText(map.get(String.valueOf(list.get(position).getSellerid())));
        } else {
            //否则隐藏起来
            holder.shangCheckbox.setChecked(list.get(position).isShopSelected());
            holder.shangjia.setVisibility(View.GONE);
        }

//        holder.shangjia.setText(shuju.get(position));
        holder.pinCheckbox.setChecked(list.get(position).isItemSelected());
        String[] split = list.get(position).getImages().split("\\|");
        holder.image.setImageURI(Uri.parse(split[0]));
        holder.title.setText(list.get(position).getTitle());
        holder.price.setText("￥:" + list.get(position).getPrice());
        holder.cust.setEditText(list.get(position).getNum());
//        holder.content.setEditText(list.get(position).getNum());
        holder.shangCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(position).setShopSelected(holder.shangCheckbox.isChecked());
                //循环商品有几件循环几次
                for (int i = 0; i < list.size(); i++) {
                    //判断商品是否全选中，如果选中所有的全选
                    if (list.get(position).getSellerid() == list.get(i).getSellerid()) {
                        list.get(i).setItemSelected(holder.shangCheckbox.isChecked());
                    }
                }
                //刷新适配器
                notifyDataSetChanged();
                //计算总价和输两天
                sum(list);
            }
        });
        holder.pinCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.get(position).setItemSelected(holder.pinCheckbox.isChecked());
                //循环
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.size(); j++) {
                        //判断商品是否点钟
                        if (list.get(i).getSellerid() == list.get(j).getSellerid() && !list.get(j).isItemSelected()) {
                            //未点中
                            list.get(i).setShopSelected(false);
                            break;
                        } else {
                            //否则点钟
                            list.get(i).setShopSelected(true);
                        }
                    }
                    //循环判断后，刷新适配
                    notifyDataSetChanged();
                    //进行计算总价和数量
                    sum(list);
                }
            }
        });
        //删除的点击事件
        holder.itemDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                persenter.getData("100", list.get(position).getPid() + "", "android");
                //list删除数据
                list.remove(position);
                setFirst(list);
                //删除完后刷新数据
                notifyDataSetChanged();
                //刷新完数据后进行计算总价和数量
                sum(list);
            }
        });
        //数量的
        holder.cust.setListener(new CustCrom.ClickListener() {
            @Override
            public void click(int count) {
                persenter2.getDara("100", list.get(position).getSellerid() + "", list.get(position).getPid() + "", list.get(position).getSelected() + ""
                        , count + "");
                list.get(position).setNum(count);
                //刷新适配器
                notifyDataSetChanged();
                sum(list);
            }

        });
    }

    private void sum(List<GoWuCheBean.DataBean.ListBean> list) {
        int totalNum = 0;
        float totalMoney = 0.0f;
        boolean allCheck = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isItemSelected()) {
                totalNum += list.get(i).getNum();
                totalMoney += list.get(i).getNum() * list.get(i).getPrice();
            } else {
                allCheck = false;
            }
        }
        //list.size()==0?false:allCheck  这是全选后再把数据都删除后，全选按钮还是全选的时候写的
        listener.setToal(totalMoney + "", totalNum + "", list.size() == 0 ? false : allCheck);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public void success(DeleteBean bean) {
        Toast.makeText(context, bean.getMsg() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(GengXinBean bean) {
        Toast.makeText(context, bean.getMsg() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(context, "错误", Toast.LENGTH_SHORT).show();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.shang_checkbox)
        CheckBox shangCheckbox;
        @BindView(R.id.shangjia)
        TextView shangjia;
        @BindView(R.id.pin_checkbox)
        CheckBox pinCheckbox;
        @BindView(R.id.image)
        SimpleDraweeView image;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.item_del)
        ImageView itemDel;
        @BindView(R.id.cust)
        CustCrom cust;


        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private UpdateUiListener listener;

    public void setListener(UpdateUiListener listener) {
        this.listener = listener;
    }

    public void selectAll(boolean check) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setShopSelected(check);
            list.get(i).setItemSelected(check);
        }
        notifyDataSetChanged();
        sum(list);
    }


    public interface UpdateUiListener {
        public void setToal(String total, String num, boolean allcheck);
    }

}