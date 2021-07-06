package br.com.mercadolivre.desafio_spring.user.dto;

import java.util.List;

public class UserFollowersDTO {

    private Long userId;
    private String userName;
    private List<FollowDTO> followers;

    public UserFollowersDTO(Long userId, String userName, List<FollowDTO> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<FollowDTO> getFollowers() {
        return followers;
    }
}
