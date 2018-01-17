package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.app.MyApp;
import com.example.cz.lianxiyuekao.bean.TheorderBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/16.
 */

public class MyTheorderMolder {
    public void get(String uid,String status, final MyTheorderCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("status", status);
        MyApp.inters.getTO(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TheorderBean>() {
                    @Override
                    public void accept(TheorderBean bean) throws Exception {
                        callBack.success(bean);
                    }
                });
    }
}
