package com.fobctech.dscommerce.dto;

import com.fobctech.dscommerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private long id;
    @Size(min = 3, max = 80, message = "Dever ter no minimo 3 caracateres")
    @NotBlank(message = "Campo Requerido")
    private String name;
    @Size(min = 10, message = "Dever ter no minimo 10 caracateres")
    @NotBlank(message = "Campo Requerido")
    private String description;
    @Positive(message = "O preço deve ser positivo")
    private double price;
    private String imgUrl;

    public ProductDTO(){}

    public ProductDTO(long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entitie){
        id = entitie.getId();
        name = entitie.getName();
        description = entitie.getDescription();
        price = entitie.getPrice();
        imgUrl = entitie.getImgUrl();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
