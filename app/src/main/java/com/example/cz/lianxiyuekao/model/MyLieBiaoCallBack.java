package com.example.cz.lianxiyuekao.model;

import com.example.cz.lianxiyuekao.bean.LieBIaoBean;

/**
 * Created by CZ on 2018/1/11.
 */

public interface MyLieBiaoCallBack {
    public void success(LieBIaoBean bean);

    public void failuer(String e);
}
