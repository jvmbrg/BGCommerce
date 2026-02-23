package com.devbraga.bragacommerce.dto;

import com.devbraga.bragacommerce.entities.Product;

public class ProductMinDTO {
    private Long id;
    private String name;
    private Double price;
    private String imgUrl;

    public ProductMinDTO(){}
    public ProductMinDTO(Long id, String imgUrl, String name, Double price) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
    }

    //Construtor para associar os atributos da classe Product diretamente ao ProductDTO, sem fazer manualmente
    public ProductMinDTO(Product entity) {
        id = entity.getId();
        imgUrl = entity.getImgUrl();
        name = entity.getName();
        price = entity.getPrice();
    }


    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
