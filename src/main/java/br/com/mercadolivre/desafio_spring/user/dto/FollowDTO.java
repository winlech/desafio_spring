package br.com.mercadolivre.desafio_spring.user.dto;

public class FollowDTO {

    private Long userId;
    private String userName;

    public FollowDTO(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
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
}
