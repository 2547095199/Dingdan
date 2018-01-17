package com.example.cz.lianxiyuekao.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cz.lianxiyuekao.R;
import com.example.cz.lianxiyuekao.adapter.TheorderAdapter;
import com.example.cz.lianxiyuekao.bean.TheorderBean;
import com.example.cz.lianxiyuekao.persenter.TheorderPersenter;
import com.example.cz.lianxiyuekao.view.TheorderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_03 extends Fragment implements TheorderView {

    private RecyclerView recyclerView;
    private View view;
    private Unbinder unbinder;
    TheorderPersenter persenter = new TheorderPersenter(this);
    private TheorderAdapter adapter;
    List<TheorderBean.DataBean> list = new ArrayList<TheorderBean.DataBean>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_03, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_03);
        persenter.getData("100", "2");

        return view;
    }


    @Override
    public void success(TheorderBean bean) {
        list.clear();
        Toast.makeText(getActivity(), bean.getData().get(0).getStatus() + "", Toast.LENGTH_SHORT).show();
        list.addAll(bean.getData());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new TheorderAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void failuer(String e) {
        Toast.makeText(getActivity(), "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        persenter.ddsdsdsdsds();
    }
}
