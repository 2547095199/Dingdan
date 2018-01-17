package com.example.cz.lianxiyuekao.persenter;

import com.example.cz.lianxiyuekao.bean.UpdateBean;
import com.example.cz.lianxiyuekao.model.MyUpdateCallBack;
import com.example.cz.lianxiyuekao.model.MyUpdateMolder;
import com.example.cz.lianxiyuekao.view.UpdateView;

/**
 * Created by CZ on 2018/1/16.
 */

public class UpdatePersenter {
    UpdateView view;
    private final MyUpdateMolder molder;

    public UpdatePersenter(UpdateView view) {
        this.view = view;
        molder = new MyUpdateMolder();
    }

    public void getData(String uid, String status, String orderId, String source) {
        molder.get(uid, status, orderId, source, new MyUpdateCallBack() {
            @Override
            public void success(UpdateBean bean) {
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

    public void fdfdfdfd() {
        this.view = null;
    }
}
