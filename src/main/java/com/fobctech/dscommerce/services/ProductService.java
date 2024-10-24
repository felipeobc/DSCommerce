package com.fobctech.dscommerce.services;

import com.fobctech.dscommerce.dto.ProductDTO;
import com.fobctech.dscommerce.entities.Product;
import com.fobctech.dscommerce.repositories.ProductRepository;
import com.fobctech.dscommerce.services.exceptions.ResourceNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findByID(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountException("Recurso não encontrado"));
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = productRepository.findAll(pageable);
        return result.map(ProductDTO::new);
    }

    @Transactional
    public ProductDTO insertNewProduct(ProductDTO dto){

        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        productRepository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO dto){
        Product entity = productRepository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        productRepository.save(entity);
        return new ProductDTO(entity);
    }

    @Transactional
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setImgUrl(dto.getImgUrl());
        entity.setPrice(dto.getPrice());
    }


}
