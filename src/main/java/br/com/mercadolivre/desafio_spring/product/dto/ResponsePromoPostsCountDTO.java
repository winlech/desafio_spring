package br.com.mercadolivre.desafio_spring.product.dto;

public class ResponsePromoPostsCountDTO {

    private Long userId;
    private String userName;
    private int promoproducts_count;

    public ResponsePromoPostsCountDTO(Long userId, String userName, int promoproducts_count) {
        this.userId = userId;
        this.userName = userName;
        this.promoproducts_count = promoproducts_count;
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

    public int getPromoproducts_count() {
        return promoproducts_count;
    }

    public void setPromoproducts_count(int promoproducts_count) {
        this.promoproducts_count = promoproducts_count;
    }
}
