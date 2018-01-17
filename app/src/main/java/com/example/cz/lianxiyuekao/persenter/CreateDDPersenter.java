package com.example.cz.lianxiyuekao.persenter;

import com.example.cz.lianxiyuekao.bean.CreateDDBean;
import com.example.cz.lianxiyuekao.model.MyCreateDDCallBack;
import com.example.cz.lianxiyuekao.model.MyCreateDDMolder;
import com.example.cz.lianxiyuekao.view.CreateDDView;

/**
 * Created by CZ on 2018/1/15.
 */

public class CreateDDPersenter {
    CreateDDView view;
    private final MyCreateDDMolder molder;

    public CreateDDPersenter(CreateDDView view) {
        this.view = view;
        molder = new MyCreateDDMolder();
    }

    public void getData(String uid, String price) {
        molder.get(uid, price, new MyCreateDDCallBack() {
            @Override
            public void success(CreateDDBean bean) {
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

    public void dsdsdsdsds() {
        this.view = null;
    }
}
