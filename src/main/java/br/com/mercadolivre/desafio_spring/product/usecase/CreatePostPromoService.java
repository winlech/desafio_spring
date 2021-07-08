package br.com.mercadolivre.desafio_spring.product.usecase;

import br.com.mercadolivre.desafio_spring.product.dto.RequestPostPromoDTO;
import br.com.mercadolivre.desafio_spring.product.repositories.PostRepository;
import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.UserNotFoundException;
import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CreatePostPromoService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public CreatePostPromoService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public HttpStatus execute(RequestPostPromoDTO postDto) {
        User user = userRepository.findById(postDto.getUserId());
        if (user == null)
            throw new UserNotFoundException();
        postRepository.save(postDto.convertToPost());
        return HttpStatus.OK;
    }
}
