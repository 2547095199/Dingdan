package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.CreateDDBean;

/**
 * Created by CZ on 2018/1/15.
 */

public interface MyCreateDDCallBack {
    public void success(CreateDDBean bean);

    public void failuer(String e);
}
