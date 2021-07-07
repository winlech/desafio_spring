package br.com.mercadolivre.desafio_spring.product.usecase;

import br.com.mercadolivre.desafio_spring.product.entities.Post;
import br.com.mercadolivre.desafio_spring.product.repositories.PostRepository;
import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import br.com.mercadolivre.desafio_spring.validations.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreatePostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public CreatePostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public HttpStatus execute(Post post) {
        User user = userRepository.findById((long) post.getUserId());
        if (user == null)
            throw new UserNotFoundException();
        postRepository.save(post);
        return HttpStatus.OK;
    }
}
