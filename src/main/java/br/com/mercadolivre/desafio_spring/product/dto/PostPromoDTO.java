package br.com.mercadolivre.desafio_spring.product.dto;

import br.com.mercadolivre.desafio_spring.product.entities.Post;
import br.com.mercadolivre.desafio_spring.product.entities.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PostPromoDTO {

    private Long id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private Product details;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;


    public static PostPromoDTO convertToPostPromoDTO(Post post) {
        return new PostPromoDTO(post.getId_post(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice(),post.getHasPromo(), post.getDiscount());
    }

    public PostPromoDTO() {
    }

    public PostPromoDTO(Long id_post, Date date, Product details, int category, double price, boolean hasPromo, double discount) {
        this.id_post = id_post;
        this.date = date;
        this.details = details;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getDetails() {
        return details;
    }

    public void setDetails(Product details) {
        this.details = details;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
