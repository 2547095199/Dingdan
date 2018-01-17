package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.TheorderBean;

/**
 * Created by CZ on 2018/1/16.
 */

public interface MyTheorderCallBack {
    public void success(TheorderBean bean);

    public void failuer(String e);
}
