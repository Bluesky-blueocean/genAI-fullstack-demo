package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1L, "Product 1", 5.0));
        products.add(new Product(2L, "Product 2", 10.0));
        products.add(new Product(3L, "Product 3", 15.0));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Product addProduct(Product product){
        product.setId((long) (products.size()+1));
        products.add(product);
        return product;
    }

    public boolean deleteProduct(Long id){
        return products.removeIf(p -> p.getId().equals(id));
    }
}
