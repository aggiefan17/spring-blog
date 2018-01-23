package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {
    private final PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String index(Model viewAndModel) {
        Iterable<Post> posts = postService.findAll();
        viewAndModel.addAttribute("posts", posts);
        return "posts index page";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String viewPost(@PathVariable String id) {
        return id + ": view an individual post";
    }

    @RequestMapping("/posts/create")
    public String viewForm(Model viewAndModel) {
        viewAndModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    private String createPost(@ModelAttribute Post post) {
        postService.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditForm(@PathVariable long id, Model viewAndModel) {
        Post post = postService.findOne(id);
        viewAndModel.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String updatePost(@ModelAttribute Post post) {
        postService.update(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String viewDeleteForm(@PathVariable long id) {
        Post post = postService.findOne(id);
        postService.delete(post);
        return "redirect:/posts";
    }

}
