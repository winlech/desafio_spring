package br.com.mercadolivre.desafio_spring.product.dto;

import java.util.List;

public class UserPostsDTO {

    private Long userId;
    private List<PostDTO> posts;

    public UserPostsDTO() {
    }

    public UserPostsDTO(Long userId, List<PostDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
