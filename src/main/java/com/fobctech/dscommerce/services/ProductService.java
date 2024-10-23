package com.fobctech.dscommerce.services;

import com.fobctech.dscommerce.dto.ProductDTO;
import com.fobctech.dscommerce.entities.Product;
import com.fobctech.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = productRepository.findAll(pageable);
        return result.map(ProductDTO::new);
    }
}
