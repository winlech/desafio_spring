package br.com.mercadolivre.desafio_spring.user.dto;

import java.util.List;

public class UserFollowedDTO {

    private Long userId;
    private String userName;
    private List<FollowDTO> followed;

    public UserFollowedDTO(Long userId, String userName, List<FollowDTO> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
    }

    public void setFollowed(List<FollowDTO> followed) {
        this.followed = followed;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<FollowDTO> getFollowed() {
        return followed;
    }
}
