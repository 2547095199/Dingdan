package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.app.MyApp;
import com.example.cz.lianxiyuekao.bean.XiangQingBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/12.
 */

public class MyXiangQingMolder {
    public void get(String pid, String source, final MyXiangQingCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        map.put("source", source);
        MyApp.inters.getXQ(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiangQingBean>() {
                    @Override
                    public void accept(XiangQingBean bean) throws Exception {
                        callBack.success(bean);
                    }
                });

    }
}
