package br.com.mercadolivre.desafio_spring.product.usecase;

import br.com.mercadolivre.desafio_spring.product.dto.PostPromoDTO;
import br.com.mercadolivre.desafio_spring.product.dto.UserPostsDTO;
import br.com.mercadolivre.desafio_spring.product.entities.Post;
import br.com.mercadolivre.desafio_spring.product.repositories.PostRepository;
import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.NotValidOrderTypeException;
import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.UserNotFoundException;
import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReadPromoPostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public ReadPromoPostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public UserPostsDTO<PostPromoDTO> execute(Long userId, String order) {
        User user = userRepository.findById(userId);
        if (user == null)
            throw new UserNotFoundException();

        List<Post> posts = postRepository.findHasPromoByUserId(userId).stream()
                                        .sorted()
                                        .collect(Collectors.toList());

        if (!order.equals("") && !order.equals("product_asc")) {
            if (!order.equals("product_desc"))
                throw new NotValidOrderTypeException();
            else
                posts = postRepository.findHasPromoByUserId(userId).stream()
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.toList());
        }

        List<PostPromoDTO> promoPosts = new ArrayList<>();

        posts.forEach(p -> promoPosts.add(PostPromoDTO.convertToPostPromoDTO(p)));

        return new UserPostsDTO<>(userId, promoPosts);
    }
}
