package br.com.mercadolivre.desafio_spring.user.usecase;

import br.com.mercadolivre.desafio_spring.user.entities.User;
import br.com.mercadolivre.desafio_spring.user.repositories.UserRepository;
import br.com.mercadolivre.desafio_spring.validations.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RemoveFollowService {

    private final UserRepository userRepository;

    public RemoveFollowService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HttpStatus execute(Long userId, Long userToUnfollow) {
        User userFollowing = userRepository.findById(userId);
        User userFollower = userRepository.findById(userToUnfollow);

        if (userFollower == null || userFollowing == null)
            throw new UserNotFoundException();

        userRepository.removeFollower(userFollowing, userFollower);
        return HttpStatus.OK;
    }
}
