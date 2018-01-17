package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.ZuCeBean;

/**
 * Created by CZ on 2018/1/10.
 */

public interface MyZuCeCllBack {
    public void success(ZuCeBean bean);

    public void failuer(String e);
}
