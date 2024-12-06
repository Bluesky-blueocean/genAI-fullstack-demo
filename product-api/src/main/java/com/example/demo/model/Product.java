package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // use lombok for getters and setters
@NoArgsConstructor
@AllArgsConstructor

public class Product {

    Long id;
    String name;
    double price;

}
