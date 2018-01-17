package com.example.cz.lianxiyuekao.persenter;

import com.example.cz.lianxiyuekao.bean.GengXinBean;
import com.example.cz.lianxiyuekao.model.MyGengXinCallBack;
import com.example.cz.lianxiyuekao.model.MyGengXinMolder;
import com.example.cz.lianxiyuekao.view.GengXInView;

/**
 * Created by CZ on 2018/1/15.
 */

public class GengXinPersenter {
    GengXInView view;
    private final MyGengXinMolder molder;

    public GengXinPersenter(GengXInView view) {
        this.view = view;
        molder = new MyGengXinMolder();
    }

    public void getDara(String uid, String sellerid, String pid, String selected, String num) {
        molder.get(uid, sellerid, pid, selected, num, new MyGengXinCallBack() {
            @Override
            public void success(GengXinBean bean) {
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

    public void dsdsdds() {
        this.view = null;
    }
}
