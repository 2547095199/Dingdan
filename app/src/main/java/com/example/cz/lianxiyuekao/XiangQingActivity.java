package com.example.cz.lianxiyuekao;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.lianxiyuekao.bean.AddGoWuCheBean;
import com.example.cz.lianxiyuekao.bean.XiangQingBean;
import com.example.cz.lianxiyuekao.eventbus.UserEvent;
import com.example.cz.lianxiyuekao.persenter.AddGoWuChePersenter;
import com.example.cz.lianxiyuekao.persenter.XiangQingPersenter;
import com.example.cz.lianxiyuekao.view.AddGoWuCheView;
import com.example.cz.lianxiyuekao.view.XiangQingView;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class XiangQingActivity extends AppCompatActivity implements XiangQingView, AddGoWuCheView {

    XiangQingPersenter persenter = new XiangQingPersenter(this);
    AddGoWuChePersenter persenter2 = new AddGoWuChePersenter(this);
    @BindView(R.id.simple)
    SimpleDraweeView simple;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.xinxi)
    TextView xinxi;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.gowuche)
    Button gowuche;
    @BindView(R.id.addgowuche)
    Button addgowuche;
    private int pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        ButterKnife.bind(this);
        EventBus.getDefault().register(XiangQingActivity.this);
        gowuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(XiangQingActivity.this, GoWuCheActivity.class);
                startActivity(intent);
            }
        });
        addgowuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                persenter2.getData(pid + "", "100","android");
            }
        });
    }

    @Override
    public void success(XiangQingBean bean) {
        String[] split = bean.getData().getImages().split("\\|");
        simple.setImageURI(Uri.parse(split[0]));
        title.setText(bean.getData().getTitle());
        xinxi.setText(bean.getData().getSubhead());
        price.setText("￥:" + bean.getData().getPrice());
    }

    @Override
    public void success(AddGoWuCheBean bean) {
        Toast.makeText(XiangQingActivity.this, bean.getMsg() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(XiangQingActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.dsdsdsds();
        EventBus.getDefault().unregister(XiangQingActivity.this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMoonEvent(UserEvent userevent) {
        pid = userevent.getPid();
        Toast.makeText(XiangQingActivity.this, userevent.getPid() + "", Toast.LENGTH_SHORT).show();
        persenter.getData(userevent.getPid() + "", "android");
//        tv_b.setText("账号："+userevent.getUsername()+"密码："+userevent.getPasswork());
    }

}
