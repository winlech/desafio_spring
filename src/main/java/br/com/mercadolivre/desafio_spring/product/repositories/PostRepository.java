package br.com.mercadolivre.desafio_spring.product.repositories;

import br.com.mercadolivre.desafio_spring.product.entities.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository {

    private static List<Post> posts;

    public PostRepository() {
        posts = new ArrayList<>();
    }

    public void save(Post post) {
        posts.add(post);
    }

    public List<Post> findAllByUserId(Long userId) {
        return posts.stream()
                .filter(p -> p.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    public List<Post> findHasPromoByUserId(Long userId) {
        return this.findAllByUserId(userId).stream()
                .filter(Post::getHasPromo)
                .collect(Collectors.toList());
    }
}
