package com.fobctech.dscommerce.dto;

import com.fobctech.dscommerce.entities.Product;

public class ProductDTO {

    private long id;
    private String name;
    private String description;
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
