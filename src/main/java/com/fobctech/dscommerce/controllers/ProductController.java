package com.fobctech.dscommerce.controllers;

import com.fobctech.dscommerce.dto.ProductDTO;
import com.fobctech.dscommerce.entities.Product;
import com.fobctech.dscommerce.repositories.ProductRepository;
import com.fobctech.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductDTO findProduct(@PathVariable Long id){
        return productService.findByID(id);

    }
}
