package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.DeleteBean;

/**
 * Created by CZ on 2018/1/15.
 */

public interface MyDeleteCallBack {
    public void success(DeleteBean bean);

    public void failuer(String e);
}
