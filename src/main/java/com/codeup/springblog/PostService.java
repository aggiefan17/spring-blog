package com.codeup.springblog;

import com.codeup.springblog.Daos.PostRepository;
import com.codeup.springblog.Daos.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postDao;

    private UsersRepository usersDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;
    }

    public PostService(UsersRepository usersDao) {
        this.usersDao = usersDao;
    }

    public PostService(){

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
