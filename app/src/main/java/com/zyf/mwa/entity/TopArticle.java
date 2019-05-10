package com.zyf.mwa.entity;

import java.util.List;

public class TopArticle extends ResponData {

    private List<Article> data;

    public List<Article> getData() {
        return data;
    }

    public void setData(List<Article> data) {
        this.data = data;
    }
}
