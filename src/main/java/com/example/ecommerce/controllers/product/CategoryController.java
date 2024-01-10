package com.example.ecommerce.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.ecommerce.entities.product.Category;
import com.example.ecommerce.services.category.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/getAllCategories")
    private ResponseEntity<List<Category>> getAllCategories()
    {
        return new ResponseEntity<List<Category>>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping(path = "/getCategoryById/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int categoryId)
    {
        return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
    }
    
    @GetMapping(path = "/getCategoryByName/{name}")
    public ResponseEntity<List<Category>> getCategoryByName(@PathVariable String name)
    {
        return new ResponseEntity<List<Category>> (categoryService.getCategoryByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/getAvailableCategory")
    public ResponseEntity<List<Category>> getAvailableCategories()
    {
        return  new ResponseEntity<List<Category>>(categoryService.getAvailableCategories(), HttpStatus.OK);
    }

    @PostMapping("/createCategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.OK);
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category)
    {
        return new ResponseEntity<Category>(categoryService.updateCategory(category), HttpStatus.OK);
    }
    
}
