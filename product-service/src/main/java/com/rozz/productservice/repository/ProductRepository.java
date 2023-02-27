package com.rozz.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rozz.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
