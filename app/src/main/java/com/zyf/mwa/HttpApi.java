package com.zyf.mwa;

import com.zyf.mwa.entity.Frequent;
import com.zyf.mwa.entity.HomeBanner;
import com.zyf.mwa.entity.HomePageList;
import com.zyf.mwa.entity.Hotkey;
import com.zyf.mwa.entity.TopArticle;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface HttpApi {


    @GET("wxarticle/chapters/json")
    Observable<ResponseBody> wxArticleChapters();

    @GET("wxarticle/list/{id}/{page}/json")
    Observable<ResponseBody> wxArticleList(@Path("id") int id, @Path("page") int page);

    @GET("banner/json")
    Observable<HomeBanner> banner();

    @POST("user/login")
    Observable<ResponseBody> login(@Query("username") String username, @Query("password") String password);

    @GET("lg/collect/list/{page}/json")
    Observable<ResponseBody> collect(@Path("page") int page);

    //-------------------------首页--------------------------------------------
    @GET("article/list/{page}/json")
    Observable<HomePageList> homeArticleList(@Path("page") int page);

    @GET("friend/json")
    Observable<Frequent> frequent();

    @GET("hotkey/json")
    Observable<Hotkey> hotkey();

    @GET("article/top/json")
    Observable<TopArticle> topArticle();
    //------------------------------------------------------------------------
}
