package br.com.mercadolivre.desafio_spring.product;

import br.com.mercadolivre.desafio_spring.product.entities.Post;
import br.com.mercadolivre.desafio_spring.product.usecase.CreatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final CreatePostService createPostService;

    @Autowired
    public ProductController(CreatePostService createPostService) {
        this.createPostService = createPostService;
    }

    @PostMapping("/newpost")
    public ResponseEntity<?> newPost(@Valid @RequestBody Post post) {
        return new ResponseEntity<>(createPostService.execute(post));
    }
}
