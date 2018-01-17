package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.app.MyApp;
import com.example.cz.lianxiyuekao.bean.CreateDDBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/15.
 */

public class MyCreateDDMolder {
    public void get(String uid, String price, final MyCreateDDCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("price", price);
        MyApp.inters.getCJDD(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CreateDDBean>() {
                    @Override
                    public void accept(CreateDDBean createDDBean) throws Exception {
                        callBack.success(createDDBean);
                    }
                });
    }
}
