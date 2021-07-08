package br.com.mercadolivre.desafio_spring.product.dto;

import java.util.List;

public class UserPostsDTO<T> {

    private Long userId;
    private List<T> posts;

    public UserPostsDTO() {
    }

    public UserPostsDTO(Long userId, List<T> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public Long getUserId() {
        return userId;
    }

    public List<T> getPosts() {
        return posts;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPosts(List<T> posts) {
        this.posts = posts;
    }
}
