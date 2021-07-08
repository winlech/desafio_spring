package br.com.mercadolivre.desafio_spring.product.usecase;

import br.com.mercadolivre.desafio_spring.product.dto.ResponsePromoPostsCountDTO;
import br.com.mercadolivre.desafio_spring.product.repositories.PostRepository;
import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.UserNotFoundException;
import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CountPromoPostsUserService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CountPromoPostsUserService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public ResponsePromoPostsCountDTO execute(Long userId) {
        User user = userRepository.findById(userId);
        if (user == null)
            throw new UserNotFoundException();
        int countP = postRepository.findHasPromoByUserId(userId).size();
        return new ResponsePromoPostsCountDTO(user.getUserId(), user.getUserName(), countP);
    }
}
