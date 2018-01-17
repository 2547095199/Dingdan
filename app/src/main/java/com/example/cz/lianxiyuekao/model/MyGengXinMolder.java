package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.app.MyApp;
import com.example.cz.lianxiyuekao.bean.GengXinBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/15.
 */

public class MyGengXinMolder {
    public void get(String uid, String sellerid, String pid, String selected, String num, final MyGengXinCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("sellerid", sellerid);
        map.put("pid", pid);
        map.put("selected", selected);
        map.put("num", num);
        MyApp.inters.getGX(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GengXinBean>() {
                    @Override
                    public void accept(GengXinBean bean) throws Exception {
                        callBack.success(bean);
                    }
                });


    }
}
