package com.example.ecommerce.repositories.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.product.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    
}
