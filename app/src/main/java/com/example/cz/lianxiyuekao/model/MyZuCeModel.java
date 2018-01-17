package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.app.MyApp;
import com.example.cz.lianxiyuekao.bean.ZuCeBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/10.
 */

public class MyZuCeModel {
    public void get(String mobile, String password, final MyZuCeCllBack cllBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("password", password);
        MyApp.inters.getZC(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZuCeBean>() {
                    @Override
                    public void accept(ZuCeBean zuCeBean) throws Exception {
                        cllBack.success(zuCeBean);
                    }
                });
    }
}
