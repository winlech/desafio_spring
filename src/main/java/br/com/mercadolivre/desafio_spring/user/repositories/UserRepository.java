package br.com.mercadolivre.desafio_spring.user.repositories;

import br.com.mercadolivre.desafio_spring.user.dto.FollowDTO;
import br.com.mercadolivre.desafio_spring.user.entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

    private static final List<User> users = new ArrayList<>(Arrays.asList(
            new User(1L, "vendedor1"),
            new User(2L, "vendedor2"),
            new User(3L, "vendedor3"),
            new User(4L, "usuario1"),
            new User(5L, "usuario2"),
            new User(6L, "usuario3"),
            new User(7L, "usuario4"),
            new User(8L, "usuario5")
        )
    );

    public void addFollow(User userToFollow, User userFollowing) {
        userToFollow.getFollowers().add(new FollowDTO(userFollowing.getUserId(), userFollowing.getUserName()));
        userFollowing.getFollowing().add(new FollowDTO(userToFollow.getUserId(), userToFollow.getUserName()));
    }

    public User findById(Long userId) {
        return users.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}
