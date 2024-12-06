package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // class below is a Rest Controller
@RequestMapping("/api/products") // base URL for all the methods below
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from localhost:3000

public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping  // maps to HTTP method 'GET /all/products'
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}") // maps to 'GET /api/products/{id}'
    public ResponseEntity<Product> getProductById (@PathVariable Long id) {
        return productService.getProductById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping  //  maps to 'POST /api/products' with JSON payload in Request Body
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PostMapping("/add") //accept URL parameters directly rather than in JSON payload
    public Product addProduct(@RequestParam("name") String name,
                              @RequestParam("price") double price) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return productService.addProduct(product);

    }

    @DeleteMapping("/{id}") // maps to 'DELETE /api/products/{id}'
    public ResponseEntity<Void> deleteProduct (@PathVariable Long id) {
        if (productService.deleteProduct(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
