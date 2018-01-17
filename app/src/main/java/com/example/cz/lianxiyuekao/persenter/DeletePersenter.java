package com.example.cz.lianxiyuekao.persenter;

import com.example.cz.lianxiyuekao.bean.DeleteBean;
import com.example.cz.lianxiyuekao.model.MyDeleteCallBack;
import com.example.cz.lianxiyuekao.model.MyDeleteMolder;
import com.example.cz.lianxiyuekao.view.DeleteView;

/**
 * Created by CZ on 2018/1/15.
 */

public class DeletePersenter {
    DeleteView view;
    private final MyDeleteMolder molder;

    public DeletePersenter(DeleteView view) {
        this.view = view;
        molder = new MyDeleteMolder();
    }

    public void getData(String uid, String pid, String source) {
        molder.get(uid, pid, source, new MyDeleteCallBack() {
            @Override
            public void success(DeleteBean bean) {
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
}
