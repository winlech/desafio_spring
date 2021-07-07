package br.com.mercadolivre.desafio_spring.product;

import br.com.mercadolivre.desafio_spring.product.dto.UserPostsDTO;
import br.com.mercadolivre.desafio_spring.product.entities.Post;
import br.com.mercadolivre.desafio_spring.product.usecase.CreatePostService;
import br.com.mercadolivre.desafio_spring.product.usecase.ReadProductsFollowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreatePostService createPostService;
    private final ReadProductsFollowedService readProductsFollowedService;

    @Autowired
    public ProductController(CreatePostService createPostService, ReadProductsFollowedService readProductsFollowedService) {
        this.createPostService = createPostService;
        this.readProductsFollowedService = readProductsFollowedService;
    }

    @PostMapping("/newpost")
    public ResponseEntity<?> newPost(@Valid @RequestBody Post post) {
        return new ResponseEntity<>(createPostService.execute(post));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostsDTO> followedList(@PathVariable Long userId) {
        return new ResponseEntity<>(readProductsFollowedService.execute(userId), HttpStatus.OK);
    }
}
