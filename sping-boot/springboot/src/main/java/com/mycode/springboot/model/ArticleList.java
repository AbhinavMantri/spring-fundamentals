package com.mycode.springboot.model;

import java.util.ArrayList;
import java.util.List;

import com.mycode.springboot.entity.Article;

public class ArticleList {
    private List<Article> articles;

    public ArticleList() {
        this.articles = new ArrayList<>();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "ArticleList [articles=" + articles + "]";
    }
}
