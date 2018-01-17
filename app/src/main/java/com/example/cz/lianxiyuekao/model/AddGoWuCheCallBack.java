package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.AddGoWuCheBean;

/**
 * Created by CZ on 2018/1/15.
 */

public interface AddGoWuCheCallBack {
    public void success(AddGoWuCheBean bean);

    public void failuer(String e);
}
