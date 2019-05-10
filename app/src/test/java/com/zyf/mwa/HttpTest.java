package com.zyf.mwa;

import android.util.Log;

import com.zyf.mwa.entity.Hotkey;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class HttpTest {
    HttpApi httpApi;

    @Before
    public void init() {
        httpApi = RetrofitUtil.getHttpApi();
    }
}
