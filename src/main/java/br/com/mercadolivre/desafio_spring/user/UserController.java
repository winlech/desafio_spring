package br.com.mercadolivre.desafio_spring.user;

import br.com.mercadolivre.desafio_spring.user.dto.UserCountDTO;
import br.com.mercadolivre.desafio_spring.user.dto.UserFollowedDTO;
import br.com.mercadolivre.desafio_spring.user.dto.UserFollowersDTO;
import br.com.mercadolivre.desafio_spring.user.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final AddFollowService addFollowService;
    private final ReadUserCountFollowersService readUserCountFollowersService;
    private final ReadUserFollowersService readUserFollowersService;
    private final ReadUserFollowedService readUserFollowedService;
    private final RemoveFollowService removeFollowService;

    @Autowired
    public UserController(AddFollowService addFollowService, ReadUserCountFollowersService readUserCountFollowersService, ReadUserFollowersService readUserFollowersService, ReadUserFollowedService readUserFollowedService, RemoveFollowService removeFollowService) {
        this.addFollowService = addFollowService;
        this.readUserCountFollowersService = readUserCountFollowersService;
        this.readUserFollowersService = readUserFollowersService;
        this.readUserFollowedService = readUserFollowedService;
        this.removeFollowService = removeFollowService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> addFollower(@PathVariable Long userId, @PathVariable Long userIdToFollow) {
            return new ResponseEntity<>(addFollowService.execute(userIdToFollow, userId));
    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<UserCountDTO> readUserCountFollowers(@PathVariable Long userId) {
        return new ResponseEntity<>(readUserCountFollowersService.execute(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> readUserFollowers(@PathVariable Long userId,
                                                              @RequestParam(required = false,
                                                                            name = "order") Optional<String> order) {
        return new ResponseEntity<>(readUserFollowersService.execute(userId, order.orElse("")), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserFollowedDTO> readUserFollowed(@PathVariable Long userId,
                                                              @RequestParam(required = false,
                                                                            name = "order") Optional<String> order) {
        return new ResponseEntity<>(readUserFollowedService.execute(userId, order.orElse("")), HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userToUnFollow}")
    public ResponseEntity<HttpStatus> unfollowUser(@PathVariable Long userId, @PathVariable Long userToUnFollow) {
        return new ResponseEntity<>(removeFollowService.execute(userId, userToUnFollow));
    }
}
