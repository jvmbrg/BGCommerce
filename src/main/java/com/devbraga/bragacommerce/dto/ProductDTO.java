package com.devbraga.bragacommerce.dto;

import com.devbraga.bragacommerce.entities.Category;
import com.devbraga.bragacommerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private Long id;

    @Size(min = 3, max = 80, message = "Esse campo deve ter de 3 a 80 caracteres")
    @NotBlank(message = "Esse campo deve ser preenchido")
    private String name;

    @Size(min = 10)
    @NotBlank(message = "Esse campo deve ter no minimo 10 caracteres")
    private String description;

    @NotNull(message = "Campo requerido")
    @Positive(message = "O preço deve ser positivo")
    private Double price;

    private String imgUrl;

    @NotEmpty(message = "Deve ter pelo menos uma categoria")
    private List<CategoryDTO> categories = new ArrayList<>();



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
        for(Category cat : entity.getCategories()){
            categories.add(new CategoryDTO(cat));
        }
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

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
