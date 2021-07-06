package br.com.mercadolivre.desafio_spring.user.entities;

import br.com.mercadolivre.desafio_spring.user.dto.FollowDTO;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long userId;
    private String userName;
    private List<FollowDTO> followers;
    private List<FollowDTO> following;

    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<FollowDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FollowDTO> followers) {
        this.followers = followers;
    }

    public List<FollowDTO> getFollowing() {
        return following;
    }

    public void setFollowing(List<FollowDTO> following) {
        this.following = following;
    }
}
