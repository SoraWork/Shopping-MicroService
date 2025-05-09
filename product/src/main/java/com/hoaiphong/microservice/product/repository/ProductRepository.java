package com.hoaiphong.microservice.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hoaiphong.microservice.product.model.Product;
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
