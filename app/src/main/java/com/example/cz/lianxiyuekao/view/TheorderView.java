package com.example.cz.lianxiyuekao.view;

import com.example.cz.lianxiyuekao.bean.TheorderBean;

/**
 * Created by CZ on 2018/1/16.
 */

public interface TheorderView {
    public void success(TheorderBean bean);

    public void failuer(String e);
}
