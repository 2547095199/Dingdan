package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.app.MyApp;
import com.example.cz.lianxiyuekao.bean.DeleteBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/15.
 */

public class MyDeleteMolder {
    public void get(String uid, String pid, String source, final MyDeleteCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("pid", pid);
        map.put("source", source);
        MyApp.inters.getD(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DeleteBean>() {
                    @Override
                    public void accept(DeleteBean bean) throws Exception {
                        callBack.success(bean);
                    }
                });
    }
}
