package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.GengXinBean;

/**
 * Created by CZ on 2018/1/15.
 */

public interface MyGengXinCallBack {
    public void success(GengXinBean bean);

    public void failuer(String e);
}
