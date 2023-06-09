package com.mycode.springboot.entity;

import org.springframework.stereotype.Component;

@Component
public class ArticleSource {
    private int id;

    private String name;

    public ArticleSource() {}

    public ArticleSource(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
