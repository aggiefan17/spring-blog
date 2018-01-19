package com.codeup.springblog;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostService {

    private List<Post> posts;

    public PostService() {
        createPosts();
    }

    private void createPosts() {
    }

    public List<Post> findAll() {
        return posts;
    }
}
