package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.app.MyApp;
import com.example.cz.lianxiyuekao.bean.LieBIaoBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/1/11.
 */

public class MyLieBiaoModel {
    //http://120.27.23.105/product/getProducts?pscid=2&page=1
    public void get(String pscid, String page, final MyLieBiaoCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("pscid", pscid);
        map.put("page", page);
        MyApp.inters.getLB(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LieBIaoBean>() {
                    @Override
                    public void accept(LieBIaoBean bean) throws Exception {
                        callBack.success(bean);
                    }
                });
    }
}
