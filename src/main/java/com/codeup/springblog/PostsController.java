package com.codeup.springblog;

import com.codeup.springblog.Daos.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {

    private final PostService postService;
    private final UsersRepository usersRepository;

    public PostsController(PostService postService, UsersRepository usersRepository) {
        this.postService = postService;
        this.usersRepository = usersRepository;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String index(Model viewAndModel) {
        Iterable<Post> posts = postService.findAll();
        viewAndModel.addAttribute("posts", posts);
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable Long id, Model viewAndModel) {
        Post post = postService.findOne(id);
        viewAndModel.addAttribute("post", post);
        return "posts/show";
    }

    @RequestMapping("/posts/create")
    public String viewForm(Model viewAndModel) {
        viewAndModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    private String createPost(@ModelAttribute Post post) {
        User user = usersRepository.findOne(1L);
        post.setUser(usersRepository.findOne(1L));
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
