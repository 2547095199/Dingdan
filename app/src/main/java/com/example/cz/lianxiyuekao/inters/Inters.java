package com.example.cz.lianxiyuekao.inters;

import com.example.cz.lianxiyuekao.bean.CreateDDBean;
import com.example.cz.lianxiyuekao.bean.DeleteBean;
import com.example.cz.lianxiyuekao.bean.DengLuBean;
import com.example.cz.lianxiyuekao.bean.AddGoWuCheBean;
import com.example.cz.lianxiyuekao.bean.GengXinBean;
import com.example.cz.lianxiyuekao.bean.GoWuCheBean;
import com.example.cz.lianxiyuekao.bean.LieBIaoBean;
import com.example.cz.lianxiyuekao.bean.UpdateBean;
import com.example.cz.lianxiyuekao.bean.TheorderBean;
import com.example.cz.lianxiyuekao.bean.XiangQingBean;
import com.example.cz.lianxiyuekao.bean.ZuCeBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by CZ on 2018/1/10.
 */

public interface Inters {
    //http://120.27.23.105/user/login
    @GET("/user/login")
    Observable<DengLuBean> getDL(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/user/reg
    @GET("/user/reg")
    Observable<ZuCeBean> getZC(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/getProducts?pscid=2&page=1
    @GET("/product/getProducts")
    Observable<LieBIaoBean> getLB(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/getProductDetail?pid=1
    @GET("/product/getProductDetail")
    Observable<XiangQingBean> getXQ(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/addCart?pid=75&uid=100
    @GET("/product/addCart")
    Observable<AddGoWuCheBean> getAGWC(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/getCarts?uid=100&source=android
    @GET("/product/getCarts")
    Observable<GoWuCheBean> getGWC(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/deleteCart?uid=72&pid=1
    @GET("/product/deleteCart")
    Observable<DeleteBean> getD(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/updateCarts?uid=100&sellerid=2&pid=25&selected=0&num=3
    @GET("/product/updateCarts")
    Observable<GengXinBean> getGX(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/createOrder?uid=100&price=99.99
    @GET("/product/createOrder")
    Observable<CreateDDBean> getCJDD(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/getOrders?uid=100&status=0&source=android
    @GET("/product/getOrders")
    Observable<TheorderBean> getTO(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/updateOrder?uid=100&status=1&orderId=4887
    @GET("/product/updateOrder")
    Observable<UpdateBean> getS(@QueryMap HashMap<String, String> map);
}
