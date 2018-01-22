package com.codeup.springblog;

import com.codeup.springblog.Daos.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private PostRepository postDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;
    }

    private List<Post> posts;



    public PostService() {
        this.posts = new ArrayList<>();
        createPosts();
    }

    private void createPosts() {
//        save(new Post("Title A", "Body A"));
//        save(new Post("Title B", "Body B"));
//        save(new Post("Title C", "Body C"));
    }


    public Iterable<Post> findAll() {
        return postDao.findAll();
    }

    public Post save(Post post) {
        return postDao.save(post);
    }

    public void update(Post post) {
    }

}
