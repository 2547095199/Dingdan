package com.example.cz.lianxiyuekao.persenter;

import com.example.cz.lianxiyuekao.bean.GoWuCheBean;
import com.example.cz.lianxiyuekao.model.MyGoWuCheCallBack;
import com.example.cz.lianxiyuekao.model.MyGoWuCheMolder;
import com.example.cz.lianxiyuekao.view.GoWuCheView;

/**
 * Created by CZ on 2018/1/15.
 */

public class GoWuChePersenter {
    GoWuCheView view;
    private final MyGoWuCheMolder molder;

    public GoWuChePersenter(GoWuCheView view) {
        this.view = view;
        molder = new MyGoWuCheMolder();
    }

    public void getData(String uid, String source) {
        molder.get(uid, source, new MyGoWuCheCallBack() {
            @Override
            public void success(GoWuCheBean bean) {
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

    public void asasss() {
        this.view = null;
    }
}
