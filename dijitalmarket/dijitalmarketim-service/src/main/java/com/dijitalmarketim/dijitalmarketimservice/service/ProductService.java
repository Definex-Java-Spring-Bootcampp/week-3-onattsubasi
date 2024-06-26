package com.dijitalmarketim.dijitalmarketimservice.service;

import org.springframework.stereotype.Service;

import com.dijitalmarketim.dijitalmarketimservice.dto.request.ProductRequest;
import com.dijitalmarketim.dijitalmarketimservice.model.Product;
import com.dijitalmarketim.dijitalmarketimservice.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
    
        this.productRepository = productRepository;
    
    }

    @Override
    public Product save(Product product)
    {
        productRepository.getAll().stream().forEach(p -> {
            
            if(p.getProductId().equals(product.getProductId())){
            
                throw new IllegalArgumentException("Product already exists");
                
            }else{
            
                productRepository.save(product);
            
            }
        
        });

        return product;
    }

    
}
