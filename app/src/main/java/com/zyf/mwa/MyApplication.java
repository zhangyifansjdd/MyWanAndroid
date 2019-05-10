package com.zyf.mwa;

import android.app.Application;

import okhttp3.OkHttpClient;

public class MyApplication extends Application {
    public static Application INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;


        new Thread() {
            @Override
            public void run() {
            }
        }.start();
    }
}
