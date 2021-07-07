package br.com.mercadolivre.desafio_spring.product.repositories;

import br.com.mercadolivre.desafio_spring.product.entities.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {

    private static List<Post> posts;

    public PostRepository() {
        posts = new ArrayList<>();
    }

    public void save(Post post) {
        posts.add(post);
    }
}
