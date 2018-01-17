package com.example.cz.lianxiyuekao.persenter;

import com.example.cz.lianxiyuekao.bean.AddGoWuCheBean;
import com.example.cz.lianxiyuekao.model.AddGoWuCheCallBack;
import com.example.cz.lianxiyuekao.model.AddGoWuCheMolder;
import com.example.cz.lianxiyuekao.view.AddGoWuCheView;

/**
 * Created by CZ on 2018/1/15.
 */

public class AddGoWuChePersenter {
    AddGoWuCheView view;
    private final AddGoWuCheMolder molder;

    public AddGoWuChePersenter(AddGoWuCheView view) {
        this.view = view;
        molder = new AddGoWuCheMolder();
    }

    public void getData(String pid, String uid,String source) {
        molder.get(pid, uid,source, new AddGoWuCheCallBack() {
            @Override
            public void success(AddGoWuCheBean bean) {
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

    public void dsdsdsdsddsdsdsdsd() {
        this.view = null;
    }
}
