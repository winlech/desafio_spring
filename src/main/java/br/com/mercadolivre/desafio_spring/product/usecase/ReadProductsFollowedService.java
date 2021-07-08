package br.com.mercadolivre.desafio_spring.product.usecase;

import br.com.mercadolivre.desafio_spring.product.dto.PostNoPromoDTO;
import br.com.mercadolivre.desafio_spring.product.entities.Post;
import br.com.mercadolivre.desafio_spring.product.dto.UserPostsDTO;
import br.com.mercadolivre.desafio_spring.product.repositories.PostRepository;
import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.NotValidOrderTypeException;
import br.com.mercadolivre.desafio_spring.user.dto.FollowDTO;
import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReadProductsFollowedService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public ReadProductsFollowedService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public UserPostsDTO<PostNoPromoDTO> execute(Long userId, String order) {
        User user = userRepository.findById(userId);
        List<PostNoPromoDTO> postsDto;

        postsDto = getAllPostsFromFollowing(user);

        postsDto = postsDto.stream()
                            .filter(p -> p.getDate().after(getDateTwoWeeksBefore()))
                            .collect(Collectors.toList());

        if (order.equals("") || order.equals("date_desc"))
            postsDto.sort(Collections.reverseOrder());
        else if (order.equals("date_asc"))
            postsDto.sort(Comparator.naturalOrder());
        else
            throw new NotValidOrderTypeException();

        return new UserPostsDTO<>(user.getUserId(), postsDto);
    }

    private List<PostNoPromoDTO> getAllPostsFromFollowing(User user) {
        List<PostNoPromoDTO> postsDto = new ArrayList<>();
        for (FollowDTO userFollowing: user.getFollowing()) {
            List<Post> posts = postRepository.findAllByUserId(userFollowing.getUserId());
            posts.forEach(p -> postsDto.add(PostNoPromoDTO.convert(p)));
        }
        return postsDto;
    }

    private Date getDateTwoWeeksBefore() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }
}
