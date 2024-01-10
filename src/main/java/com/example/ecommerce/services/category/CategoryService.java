package com.example.ecommerce.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.example.ecommerce.entities.product.Category;
import com.example.ecommerce.repositories.product.CategoryRepository;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories()
    {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category getCategoryById(int categoryId)
    {
        return categoryRepository.findById(categoryId).orElseThrow(()->new RuntimeException("No category exists with this id"));
    }

    public Category createCategory(Category category)
    {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category)
    {
        getCategoryById(category.getId());
        return categoryRepository.save(category);
    }

    public List<Category> getCategoryByName(String name)
    {
        return categoryRepository.getCategoryByName(name);
    } 

    public List<Category> getAvailableCategories()
    {
        return categoryRepository.getAvailableCategories();
    }
}
