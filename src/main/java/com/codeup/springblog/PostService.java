package com.codeup.springblog;

import com.codeup.springblog.Daos.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;
    }

    public Iterable<Post> findAll() {
        return postDao.findAll();
    }

    public Post findOne(Long id) {
        return postDao.findOne(id);
    }

    public void save(Post post) {
        postDao.save(post);
    }

    public void update(Post post) {
        postDao.save(post);
    }

    public void delete(Post post) {
        postDao.delete(post);
    }

}
