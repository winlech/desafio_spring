package br.com.mercadolivre.desafio_spring.product.dto;

import br.com.mercadolivre.desafio_spring.product.entities.Post;
import br.com.mercadolivre.desafio_spring.product.entities.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PostNoPromoDTO implements Comparable<PostNoPromoDTO> {

    private Long id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private Product details;
    private int category;
    private double price;

    public PostNoPromoDTO() {
    }

    public PostNoPromoDTO(Long id_post, Date date, Product details, int category, double price) {
        this.id_post = id_post;
        this.date = date;
        this.details = details;
        this.category = category;
        this.price = price;
    }

    public static PostNoPromoDTO convert(Post post) {
        return new PostNoPromoDTO(post.getId_post(), post.getDate(), post.getDetail(), post.getCategory(), post.getPrice());
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

    @Override
    public int compareTo(PostNoPromoDTO o) {
        return this.getDate().compareTo(o.getDate());
    }
}
