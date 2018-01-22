package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {
    private final PostService service;

    public PostsController(PostService service) {
        this.service = service;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "posts index page";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String viewPost(@PathVariable String id) {
        return id + ": view an individual post";
    }

    @RequestMapping("/posts/create")
    public String viewForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    private String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ) {
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        return "posts/create";
    }

}
