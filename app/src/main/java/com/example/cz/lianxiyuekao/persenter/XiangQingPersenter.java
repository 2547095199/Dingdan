package com.example.cz.lianxiyuekao.persenter;

import com.example.cz.lianxiyuekao.bean.XiangQingBean;
import com.example.cz.lianxiyuekao.model.MyXiangQingCallBack;
import com.example.cz.lianxiyuekao.model.MyXiangQingMolder;
import com.example.cz.lianxiyuekao.view.XiangQingView;

/**
 * Created by CZ on 2018/1/15.
 */

public class XiangQingPersenter {
    XiangQingView view;
    private final MyXiangQingMolder molder;

    public XiangQingPersenter(XiangQingView view) {
        this.view = view;
        molder = new MyXiangQingMolder();
    }

    public void getData(String pid, String source) {
        molder.get(pid, source, new MyXiangQingCallBack() {
            @Override
            public void success(XiangQingBean bean) {
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

    public void dsdsdsds() {
        this.view = null;
    }
}
