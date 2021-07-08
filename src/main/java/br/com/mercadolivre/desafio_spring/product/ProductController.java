package br.com.mercadolivre.desafio_spring.product;

import br.com.mercadolivre.desafio_spring.product.dto.*;
import br.com.mercadolivre.desafio_spring.product.usecase.CountPromoPostsUserService;
import br.com.mercadolivre.desafio_spring.product.usecase.CreatePostNoPromoService;
import br.com.mercadolivre.desafio_spring.product.usecase.CreatePostPromoService;
import br.com.mercadolivre.desafio_spring.product.usecase.ReadProductsFollowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreatePostNoPromoService createPostNoPromoServiceNoPromo;
    private final CreatePostPromoService createPostPromoService;
    private final ReadProductsFollowedService readProductsFollowedService;
    private final CountPromoPostsUserService countPromoPostsUserService;

    @Autowired
    public ProductController(CreatePostNoPromoService createPostNoPromoService, CreatePostNoPromoService createPostNoPromoServiceNoPromo, CreatePostPromoService createPostPromoService, ReadProductsFollowedService readProductsFollowedService, CountPromoPostsUserService countPromoPostsUserService) {
        this.createPostNoPromoServiceNoPromo = createPostNoPromoServiceNoPromo;
        this.createPostPromoService = createPostPromoService;
        this.readProductsFollowedService = readProductsFollowedService;
        this.countPromoPostsUserService = countPromoPostsUserService;
    }

    @PostMapping("/newpost")
    public ResponseEntity<?> newPost(@Valid @RequestBody RequestPostNoPromoDTO post) {
        return new ResponseEntity<>(createPostNoPromoServiceNoPromo.execute(post));
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<UserPostsDTO<PostNoPromoDTO>> followedList(@PathVariable Long userId,
                                                                     @RequestParam(required = false,
                                                                    name = "order")Optional<String> order) {
        return new ResponseEntity<>(readProductsFollowedService.execute(userId, order.orElse("")), HttpStatus.OK);
    }

    @PostMapping("/newpromopost")
    public ResponseEntity<?> newPromoPost(@Valid @RequestBody RequestPostPromoDTO post) {
        return new ResponseEntity<>(createPostPromoService.execute(post));
    }

    @GetMapping("/{userId}/countPromo/")
    public ResponseEntity<ResponsePromoPostsCountDTO> getCountPromo(@PathVariable Long userId) {
        return new ResponseEntity<>(countPromoPostsUserService.execute(userId), HttpStatus.OK);
    }

}
