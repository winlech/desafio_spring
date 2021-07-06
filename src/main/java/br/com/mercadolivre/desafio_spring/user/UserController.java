package br.com.mercadolivre.desafio_spring.user;

import br.com.mercadolivre.desafio_spring.user.dto.UserCountDTO;
import br.com.mercadolivre.desafio_spring.user.usecase.AddFollowService;
import br.com.mercadolivre.desafio_spring.user.usecase.ReadUserCountFollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final AddFollowService addFollowService;
    private final ReadUserCountFollowersService readUserCountFollowersService;

    @Autowired
    public UserController(AddFollowService addFollowService, ReadUserCountFollowersService readUserCountFollowersService) {
        this.addFollowService = addFollowService;
        this.readUserCountFollowersService = readUserCountFollowersService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<HttpStatus> addFollower(@PathVariable Long userId, @PathVariable Long userIdToFollow) {
            return new ResponseEntity<>(addFollowService.execute(userIdToFollow, userId));
    }

    @GetMapping("/{userId}/followers/count/")
    public ResponseEntity<UserCountDTO> readUserCountFollowers(@PathVariable Long userId) {
        return new ResponseEntity<>(readUserCountFollowersService.execute(userId), HttpStatus.OK);
    }
}
