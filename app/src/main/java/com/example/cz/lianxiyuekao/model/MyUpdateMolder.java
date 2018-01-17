package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.app.MyApp;
import com.example.cz.lianxiyuekao.bean.UpdateBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/16.
 */

public class MyUpdateMolder {
    public void get(String uid, String status, String orderId, String source, final MyUpdateCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("status", status);
        map.put("orderId", orderId);
        map.put("source", source);
        MyApp.inters.getS(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UpdateBean>() {
                    @Override
                    public void accept(UpdateBean screeningBean) throws Exception {
                        callBack.success(screeningBean);
                    }
                });
    }
}
