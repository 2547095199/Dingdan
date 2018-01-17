package com.example.cz.lianxiyuekao.persenter;

import com.example.cz.lianxiyuekao.bean.LieBIaoBean;
import com.example.cz.lianxiyuekao.model.MyLieBiaoCallBack;
import com.example.cz.lianxiyuekao.model.MyLieBiaoModel;
import com.example.cz.lianxiyuekao.view.LieBiaoView;

/**
 * Created by CZ on 2018/1/11.
 */

public class LieBiaoPersenter {
    LieBiaoView view;
    private final MyLieBiaoModel model;

    public LieBiaoPersenter(LieBiaoView view) {
        this.view = view;
        model = new MyLieBiaoModel();
    }

    public void getData(String pscid, String page) {
        model.get(pscid, page, new MyLieBiaoCallBack() {
            @Override
            public void success(LieBIaoBean bean) {
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

    public void sdsd() {
        this.view = null;
    }
}
