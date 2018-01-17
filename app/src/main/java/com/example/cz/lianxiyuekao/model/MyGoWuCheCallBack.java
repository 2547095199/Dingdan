package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.GoWuCheBean;

/**
 * Created by CZ on 2018/1/15.
 */

public interface MyGoWuCheCallBack {
    public void success(GoWuCheBean bean);

    public void failuer(String e);
}
