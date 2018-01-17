package com.example.cz.lianxiyuekao.bean;

import java.util.List;

/**
 * Created by CZ on 2018/1/16.
 */

public class TheorderBean {
    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-10-21T21:05:31","orderid":606,"price":18466,"status":2,"title":"","uid":100},{"createtime":"2017-11-21T14:12:26","orderid":2592,"price":99.99,"status":0,"title":null,"uid":100},{"createtime":"2017-11-21T20:26:10","orderid":2930,"price":86.97999999999999,"status":0,"title":null,"uid":100},{"createtime":"2017-12-15T19:53:26","orderid":3417,"price":99.99,"status":0,"title":null,"uid":100},{"createtime":"2017-12-19T11:00:56","orderid":3515,"price":65467,"status":0,"title":"订单测试标题100","uid":100},{"createtime":"2017-12-21T10:15:01","orderid":4887,"price":99.99,"status":0,"title":"订单测试标题100","uid":100},{"createtime":"2017-12-21T10:15:05","orderid":4888,"price":99.99,"status":0,"title":"订单测试标题100","uid":100},{"createtime":"2017-12-21T10:16:06","orderid":4893,"price":99.99,"status":0,"title":"订单测试标题100","uid":100},{"createtime":"2017-12-21T10:31:01","orderid":4916,"price":99.99,"status":0,"title":"订单测试标题100","uid":100},{"createtime":"2017-12-21T10:39:43","orderid":4929,"price":99.99,"status":0,"title":"订单测试标题100","uid":100}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-10-21T21:05:31
         * orderid : 606
         * price : 18466.0
         * status : 2
         * title :
         * uid : 100
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private String title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
