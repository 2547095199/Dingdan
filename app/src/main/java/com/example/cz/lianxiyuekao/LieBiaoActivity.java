package com.example.cz.lianxiyuekao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.cz.lianxiyuekao.adapter.LieBiaoAdapter;
import com.example.cz.lianxiyuekao.bean.LieBIaoBean;
import com.example.cz.lianxiyuekao.eventbus.UserEvent;
import com.example.cz.lianxiyuekao.persenter.LieBiaoPersenter;
import com.example.cz.lianxiyuekao.view.LieBiaoView;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LieBiaoActivity extends AppCompatActivity implements LieBiaoView {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.springview)
    SpringView springview;
    LieBiaoPersenter persenter = new LieBiaoPersenter(this);
    List<LieBIaoBean.DataBean> list = new ArrayList<LieBIaoBean.DataBean>();
    private LieBiaoAdapter adapter;
    private int page = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lie_biao);
        ButterKnife.bind(this);
        persenter.getData("2", "1");
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(manager);
        springview.setHeader(new DefaultHeader(this));
        springview.setFooter(new DefaultFooter(this));
        //设置SpringView的刷新监听事件
        springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                springview.onFinishFreshAndLoad();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadmore() {
                page++;
                persenter.getData("2", page + "");
                springview.onFinishFreshAndLoad();

            }
        });


    }

    @Override
    public void success(final LieBIaoBean bean) {
        for (int i = 0; i < bean.getData().size(); i++) {
            list.add(bean.getData().get(i));
        }
        adapter = new LieBiaoAdapter(list, LieBiaoActivity.this);
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickListener(new LieBiaoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int pid = list.get(position).getPid();
                EventBus.getDefault().postSticky(new UserEvent(pid));
                startActivity(new Intent(LieBiaoActivity.this,XiangQingActivity.class));

            }
        });

    }

    @Override
    public void failuer(String e) {
        Toast.makeText(LieBiaoActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.sdsd();
    }
}
