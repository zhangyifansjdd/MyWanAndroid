package com.zyf.mwa;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zyf.mwa.entity.Frequent;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewPager = findViewById(R.id.viewpager);

        final HttpApi httpApi = RetrofitUtil.getHttpApi();

//        Observable.zip(httpApi.topArticle().subscribeOn(Schedulers.io()),
//                httpApi.homeArticleList(0).subscribeOn(Schedulers.io()),
//                new BiFunction<TopArticle, HomePageList, List<Article>>() {
//                    @Override
//                    public List<Article> apply(TopArticle topArticle, HomePageList homePageList) throws Exception {
//                        Log.i("ZYF_TAG", "BiFunction: " + Thread.currentThread().getName());
//                        List<Article> list = new ArrayList<>();
//                        list.addAll(topArticle.getData());
//                        list.addAll(homePageList.getData().getDatas());
//                        return list;
//                    }
//                }).observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<List<Article>>() {
//                    @Override
//                    public void accept(List<Article> articles) throws Exception {
//                        Log.i("ZYF_TAG", "Consumer: " + Thread.currentThread().getName());
//                    }
//                });

        httpApi.frequent()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Frequent>() {
                    @Override
                    public void accept(Frequent frequent) throws Exception {
                        Log.i("ZYF_TAG", "accept: "+frequent);
                    }
                });
    }
}
