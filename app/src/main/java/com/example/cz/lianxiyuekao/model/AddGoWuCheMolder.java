package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.app.MyApp;
import com.example.cz.lianxiyuekao.bean.AddGoWuCheBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/15.
 */

public class AddGoWuCheMolder {
    public void get(String pid, String uid, String source, final AddGoWuCheCallBack cheCallBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        map.put("uid", uid);
        map.put("source", source);
        MyApp.inters.getAGWC(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddGoWuCheBean>() {
                    @Override
                    public void accept(AddGoWuCheBean bean) throws Exception {
                        cheCallBack.success(bean);
                    }
                });
    }
}
