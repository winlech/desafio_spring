package br.com.mercadolivre.desafio_spring.user.dto;

public class UserCountDTO {

    private Long id;
    private String userName;
    private Integer countFollowers;

    public UserCountDTO(Long id, String userName, Integer countFollowers) {
        this.id = id;
        this.userName = userName;
        this.countFollowers = countFollowers;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getCountFollowers() {
        return countFollowers;
    }
}
