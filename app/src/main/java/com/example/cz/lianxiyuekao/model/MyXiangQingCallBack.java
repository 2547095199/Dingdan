package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.XiangQingBean;

/**
 * Created by CZ on 2018/1/12.
 */

public interface MyXiangQingCallBack {
    public void success(XiangQingBean bean);

    public void failuer(String e);
}
