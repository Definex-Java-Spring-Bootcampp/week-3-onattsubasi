package com.dijitalmarketim.dijitalmarketimservice.controller;

import com.dijitalmarketim.dijitalmarketimservice.dto.request.ProductRequest;
import com.dijitalmarketim.dijitalmarketimservice.model.Product;
import com.dijitalmarketim.dijitalmarketimservice.service.ProductService;
import com.dijitalmarketim.dijitalmarketimservice.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
    
        return productService.save(product);
    }

    

}
