package com.codeup.springblog;

import javax.persistence.*;

@Entity
@Table(name="post")
public class Post {
    @Id @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String title;
    private String body;

    @ManyToOne
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
