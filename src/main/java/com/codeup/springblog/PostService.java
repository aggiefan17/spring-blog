package com.codeup.springblog;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> posts;

    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    private void createPosts() {
//        save(new Post(title: "Title A", body: "Body A"));
//        save(new Post(title: "Title A", body: "Body A"));
//        save(new Post(title: "Title A", body: "Body A"));
    }

//    private void save(Post post) {
//        post.setId(posts.size() + 1);
//    }

    public List<Post> findAll() {
        return posts;
    }

    public String save(@ModelAttribute Post post) {
        return "posts/create";
    }
}
