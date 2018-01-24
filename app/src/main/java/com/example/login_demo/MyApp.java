package com.example.login_demo;

import android.app.Application;
import android.content.Context;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by 地地 on 2018/1/19.
 * 邮箱：461211527@qq.com.
 */

public class MyApp extends Application {
    public  static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        AutoLayoutConifg.getInstance().useDeviceSize();
    }
}
