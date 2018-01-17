package com.example.cz.lianxiyuekao.app;

import android.app.Application;

import com.example.cz.lianxiyuekao.LoggingInterceptor;
import com.example.cz.lianxiyuekao.inters.Inters;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CZ on 2018/1/10.
 */

public class MyApp extends Application {

    public static Inters inters;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(new LoggingInterceptor())
//                .connectTimeout(30, TimeUnit.SECONDS)
//                .readTimeout(30, TimeUnit.SECONDS)
//                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://120.27.23.105")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(client)
                .build();
        inters = retrofit.create(Inters.class);

    }
//    public static Inters getInters(){
//        return inters;
//    }
}
