package com.codeup.springblog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String body;


    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
