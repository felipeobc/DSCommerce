package com.fobctech.dscommerce.controllers;

import com.fobctech.dscommerce.dto.ProductDTO;

import com.fobctech.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findProduct(@PathVariable Long id){
        ProductDTO dto = productService.findByID(id);
        return ResponseEntity.ok(dto);

    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAllProducts(Pageable pageable){
        Page<ProductDTO> dto = productService.findAll(pageable);
        return ResponseEntity.ok(dto);

    }

    @PostMapping
    public ResponseEntity<ProductDTO> insertNewProdusct(@RequestBody ProductDTO dto){

        dto = productService.insertNewProduct(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);


    }

    @PutMapping( value = "/{id}")
    public ResponseEntity<ProductDTO> updateProdusct(@PathVariable Long id, @RequestBody ProductDTO dto){
        dto = productService.updateProduct(id, dto);
        return ResponseEntity.ok(dto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduc(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();

    }


}
