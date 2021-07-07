package br.com.mercadolivre.desafio_spring.product.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Post {

    @NotNull
    private int userId;
    @NotNull
    private int id_post;

    @NotNull
    @JsonSerialize(as = Date.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",
            lenient = OptBoolean.FALSE, locale = "pt-BR", timezone = "America/Sao_Paulo")
    private Date date;

    @NotNull
    private Product detail;
    @NotNull
    private int category;
    @NotNull
    private double price;

    public Post() {
    }

    public Post(int userId, int id_post, Date date, Product detail, int category, double price) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public int getId_post() {
        return id_post;
    }

    public Date getDate() {
        return date;
    }

    public Product getDetail() {
        return detail;
    }

    public int getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDetail(Product detail) {
        this.detail = detail;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
