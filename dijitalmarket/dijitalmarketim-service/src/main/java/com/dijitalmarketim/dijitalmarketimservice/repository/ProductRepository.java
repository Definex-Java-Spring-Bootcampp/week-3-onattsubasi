package com.dijitalmarketim.dijitalmarketimservice.repository;

import com.dijitalmarketim.dijitalmarketimservice.model.Product;
import java.util.List;
import java.util.ArrayList;

public class ProductRepository {

    private List<Product> productList = new ArrayList<>();

    public void save(Product product) {
        productList.add(product);
    
    }

    public List<Product> getAll() {
    
        return productList;
    }

    public void delete(Product product) {
        productList.remove(product);
    
    }


}
