package com.example.cz.lianxiyuekao.persenter;

import com.example.cz.lianxiyuekao.bean.TheorderBean;
import com.example.cz.lianxiyuekao.model.MyTheorderCallBack;
import com.example.cz.lianxiyuekao.model.MyTheorderMolder;
import com.example.cz.lianxiyuekao.view.TheorderView;

/**
 * Created by CZ on 2018/1/16.
 */

public class TheorderPersenter {
    TheorderView view;
    private final MyTheorderMolder molder;

    public TheorderPersenter(TheorderView view) {
        this.view = view;
        molder = new MyTheorderMolder();
    }

    public void getData(String uid, String status) {
        molder.get(uid, status, new MyTheorderCallBack() {
            @Override
            public void success(TheorderBean bean) {
                if (view != null) {
                    view.success(bean);
                }
            }

            @Override
            public void failuer(String e) {
                if (view != null) {
                    view.failuer(e);
                }
            }
        });
    }

    public void ddsdsdsdsds() {
        this.view = null;
    }
}
