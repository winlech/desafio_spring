package br.com.mercadolivre.desafio_spring.user.usecase;

import br.com.mercadolivre.desafio_spring.user.dto.UserCountDTO;
import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReadUserCountFollowersService {

    private final UserRepository userRepository;

    @Autowired
    public ReadUserCountFollowersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserCountDTO execute(Long userId) {
        User user = userRepository.findById(userId);
        if (user == null)
            throw new UserNotFoundException();
        return new UserCountDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }

}
