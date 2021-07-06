package br.com.mercadolivre.desafio_spring.user.usecase;

import br.com.mercadolivre.desafio_spring.user.dto.UserFollowersDTO;
import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import br.com.mercadolivre.desafio_spring.validations.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadUserFollowersService {

    private final UserRepository userRepository;

    @Autowired
    public ReadUserFollowersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserFollowersDTO execute(Long userId) {
        User user = userRepository.findById(userId);
        if (user == null)
            throw new UserNotFoundException();
        return new UserFollowersDTO(user.getUserId(), user.getUserName(), user.getFollowers());
    }
}
