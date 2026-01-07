package com.devbraga.bragacommerce.dto;

import com.devbraga.bragacommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    private Long id;

    @Size(min = 3, max = 80, message = "Esse campo deve ter de 3 a 80 caracteres")
    @NotBlank(message = "Esse campo deve ser preenchido")
    private String name;

    @Size(min = 10)
    @NotBlank(message = "Esse campo deve ter no minimo 10 caracteres")
    private String description;

    @Positive(message = "O preço deve ser positivo")
    private Double price;

    private String imgUrl;

    public ProductDTO(){}
    public ProductDTO(String description, Long id, String imgUrl, String name, Double price) {
        this.description = description;
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.price = price;
    }

    //Construtor para associar os atributos da classe Product diretamente ao ProductDTO, sem fazer manualmente
    public ProductDTO(Product entity) {
        description = entity.getDescription();
        id = entity.getId();
        imgUrl = entity.getImgUrl();
        name = entity.getName();
        price = entity.getPrice();
    }

    public String getDescription() {
        return description;
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
