package com.zyf.mwa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zyf.mwa.entity.HomeBanner;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends PagerAdapter {
    Context context;
    HomeBanner homeBanner;
    List<ImageView> imageViewList;

    public BannerAdapter(Context context, HomeBanner homeBanner) {
        this.homeBanner = homeBanner;
        this.context = context;

        imageViewList = new ArrayList<>();
        for (HomeBanner.Data data : homeBanner.getData()) {
            imageViewList.add((ImageView) LayoutInflater.from(context).inflate(R.layout.item_banner, null));
        }
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = imageViewList.get(position);
        String path = homeBanner.getData().get(position).getImagePath();
        container.addView(imageView);
        Glide.with(context).load(path).into(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(imageViewList.get(position));
    }

    @Override
    public int getCount() {
        return homeBanner.getData().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
