package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.app.MyApp;
import com.example.cz.lianxiyuekao.bean.GoWuCheBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/15.
 */

public class MyGoWuCheMolder {
    public void get(String uid, String source, final MyGoWuCheCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("source", source);
        MyApp.inters.getGWC(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoWuCheBean>() {
                    @Override
                    public void accept(GoWuCheBean bean) throws Exception {
                        callBack.success(bean);
                    }
                });
    }
}
