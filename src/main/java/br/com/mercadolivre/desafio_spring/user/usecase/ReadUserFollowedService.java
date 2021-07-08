package br.com.mercadolivre.desafio_spring.user.usecase;

import br.com.mercadolivre.desafio_spring.shared.utils.OrderUserNameFollow;
import br.com.mercadolivre.desafio_spring.user.dto.UserFollowedDTO;
import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadUserFollowedService {

    private final UserRepository userRepository;

    @Autowired
    public ReadUserFollowedService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserFollowedDTO execute(Long userId, String s) {
        User user = userRepository.findById(userId);
        UserFollowedDTO userFollowedDTO;

        if (user == null)
            throw new UserNotFoundException();

        userFollowedDTO = new UserFollowedDTO(user.getUserId(), user.getUserName(), user.getFollowing());
        userFollowedDTO.setFollowed(OrderUserNameFollow.execute(s, userFollowedDTO.getFollowed()));

        return userFollowedDTO;
    }
}
