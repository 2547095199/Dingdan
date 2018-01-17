package com.example.cz.lianxiyuekao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.cz.lianxiyuekao.adapter.FragAdapter;
import com.example.cz.lianxiyuekao.fragment.Fragment_01;
import com.example.cz.lianxiyuekao.fragment.Fragment_02;
import com.example.cz.lianxiyuekao.fragment.Fragment_03;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TheorderActivity extends AppCompatActivity {

    @BindView(R.id.popwindow)
    ImageView popwindow;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.viewpager)
    ViewPager viewpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theorder);
        ButterKnife.bind(this);
        Fragment_01 fragment_01 = new Fragment_01();
        Fragment_02 fragment_02 = new Fragment_02();
        Fragment_03 fragment_03 = new Fragment_03();
        List<Fragment> list = new ArrayList<>();
        list.add(fragment_01);
        list.add(fragment_02);

        list.add(fragment_03);
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(adapter);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        group.check(R.id.radio_01);
                        break;
                    case 1:
                        group.check(R.id.radio_02);
                        break;
                    case 2:
                        group.check(R.id.radio_03);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio_01:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.radio_02:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.radio_03:
                        viewpager.setCurrentItem(2);
                        break;
                }
            }
        });

    }
}
