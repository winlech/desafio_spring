package br.com.mercadolivre.desafio_spring.user.usecase;

import br.com.mercadolivre.desafio_spring.shared.utils.OrderUserNameFollow;
import br.com.mercadolivre.desafio_spring.user.dto.FollowDTO;
import br.com.mercadolivre.desafio_spring.user.dto.UserFollowersDTO;
import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import br.com.mercadolivre.desafio_spring.validations.exceptions.NotValidOrderTypeException;
import br.com.mercadolivre.desafio_spring.validations.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class ReadUserFollowersService {

    private final UserRepository userRepository;

    @Autowired
    public ReadUserFollowersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserFollowersDTO execute(Long userId, String s) {
        User user = userRepository.findById(userId);
        UserFollowersDTO userFollowersDTO;

        if (user == null)
            throw new UserNotFoundException();

        userFollowersDTO = new UserFollowersDTO(user.getUserId(), user.getUserName(), user.getFollowers());
        userFollowersDTO.setFollowers(OrderUserNameFollow.execute(s, userFollowersDTO.getFollowers()));

        return userFollowersDTO;
    }
}
