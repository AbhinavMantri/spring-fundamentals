package com.mycode.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mycode.springboot.entity.Article;
import com.mycode.springboot.model.ArticleList;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Value("${news.apikey}")
    private String apiKey;

    private RestTemplate restTemplate;

    public NewsController(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/get-news")
    public List<Article> getNews() {
       ArticleList response = new ArticleList();
       try {
        response = restTemplate.getForObject(
        "https://newsapi.org/v2/everything?q=tesla&from=2023-02-24&sortBy=publishedAt&apiKey=" + apiKey, ArticleList.class);
       } catch(Exception ex) {
            ex.printStackTrace();
       }
       
        return response != null ? response.getArticles() : new ArrayList<>();
    }
}
