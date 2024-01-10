package com.example.ecommerce.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.product.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{
    public List<Category> getCategoryByName(String name);

    @Query("Select c from Category as c where c.available = true")
    public List<Category> getAvailableCategories();
}
