package com.example.cz.lianxiyuekao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cz.lianxiyuekao.adapter.MyAdapter;
import com.example.cz.lianxiyuekao.bean.CreateDDBean;
import com.example.cz.lianxiyuekao.bean.GoWuCheBean;
import com.example.cz.lianxiyuekao.persenter.CreateDDPersenter;
import com.example.cz.lianxiyuekao.persenter.GoWuChePersenter;
import com.example.cz.lianxiyuekao.view.CreateDDView;
import com.example.cz.lianxiyuekao.view.GoWuCheView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoWuCheActivity extends AppCompatActivity implements GoWuCheView, View.OnClickListener, CreateDDView {

    @BindView(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @BindView(R.id.third_allselect)
    CheckBox thirdAllselect;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    GoWuChePersenter persenter = new GoWuChePersenter(this);
    CreateDDPersenter persenter2 = new CreateDDPersenter(this);
    private MyAdapter adapter;
    private String total1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_wu_che);
        ButterKnife.bind(this);
        persenter.getData("100", "android");

        thirdAllselect.setOnClickListener(this);
        adapter = new MyAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        thirdRecyclerview.setLayoutManager(manager);
        //recyclerview里添加数据
        thirdRecyclerview.setAdapter(adapter);
        Log.e("数据", adapter.toString());
        //适配器的事件
        adapter.setListener(new MyAdapter.UpdateUiListener() {

            @Override
            public void setToal(String total, String num, boolean allcheck) {
                total1 = total;
                thirdAllselect.setChecked(allcheck);
                thirdTotalnum.setText(num);
                thirdTotalprice.setText(total);
            }
        });
        thirdSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GoWuCheActivity.this, total1 + "", Toast.LENGTH_SHORT).show();
                if (thirdAllselect.isChecked() == true) {
                    persenter2.getData("100", total1 + "");
                    Intent intent = new Intent(GoWuCheActivity.this, TheorderActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(GoWuCheActivity.this, "价格必须得选中，否则创建不了订单", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void success(GoWuCheBean bean) {
        adapter.add(bean);
    }

    @Override
    public void success(CreateDDBean bean) {
        Toast.makeText(GoWuCheActivity.this, bean.getMsg() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(GoWuCheActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.asasss();
        persenter2.dsdsdsdsds();
    }

    @Override
    public void onClick(View view) {
        adapter.selectAll(thirdAllselect.isChecked());
    }
}
