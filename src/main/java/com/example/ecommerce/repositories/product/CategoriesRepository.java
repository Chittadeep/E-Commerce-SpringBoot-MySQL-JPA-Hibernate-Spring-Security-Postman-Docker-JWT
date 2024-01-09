package com.example.ecommerce.repositories.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.product.Category;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Integer>{
    
}
