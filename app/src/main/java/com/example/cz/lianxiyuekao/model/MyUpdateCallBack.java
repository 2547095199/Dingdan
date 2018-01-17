package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.UpdateBean;

/**
 * Created by CZ on 2018/1/16.
 */

public interface MyUpdateCallBack {
    public void success(UpdateBean bean);

    public void failuer(String e);
}
