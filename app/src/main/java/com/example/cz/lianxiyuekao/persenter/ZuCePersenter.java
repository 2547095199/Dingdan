package com.example.cz.lianxiyuekao.persenter;

import com.example.cz.lianxiyuekao.bean.ZuCeBean;
import com.example.cz.lianxiyuekao.model.MyZuCeCllBack;
import com.example.cz.lianxiyuekao.model.MyZuCeModel;
import com.example.cz.lianxiyuekao.view.ZuCeView;

/**
 * Created by CZ on 2018/1/10.
 */

public class ZuCePersenter {
    ZuCeView view;
    private final MyZuCeModel model;

    public ZuCePersenter(ZuCeView view) {
        this.view = view;
        model = new MyZuCeModel();
    }

    public void getDara(String mobile, String password) {
        model.get(mobile, password, new MyZuCeCllBack() {
            @Override
            public void success(ZuCeBean bean) {
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

    public void dfsdsds() {
        this.view = null;
    }
}
