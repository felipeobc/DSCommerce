package com.fobctech.dscommerce.services;

import com.fobctech.dscommerce.dto.ProductDTO;
import com.fobctech.dscommerce.entities.Product;
import com.fobctech.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findByID(Long id){
        Optional<Product> result = productRepository.findById(1L);
        Product product = result.get();
        return new ProductDTO(product);
    }
}