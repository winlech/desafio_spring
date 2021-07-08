package br.com.mercadolivre.desafio_spring.user.usecase;

import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.NotValidFollowException;
import br.com.mercadolivre.desafio_spring.shared.validations.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AddFollowService {

    private final UserRepository userRepository;

    @Autowired
    public AddFollowService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HttpStatus execute(Long userIdToFollow, Long userId) throws UserNotFoundException {
        if (userIdToFollow.equals(userId))
            throw new NotValidFollowException();
        User userToFollow = userRepository.findById(userIdToFollow);
        User userFollowing = userRepository.findById(userId);
        if (userToFollow == null || userFollowing == null)
            throw new UserNotFoundException();
        userRepository.addFollow(userToFollow, userFollowing);
        return HttpStatus.OK;
    }
}
