package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.DengLuBean;

/**
 * Created by CZ on 2018/1/10.
 */

public interface MyDengLuCallBack {
    public void success(DengLuBean bean);

    public void failuer(String e);
}
