package com.example.ecommerce.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;
import java.util.List;

import com.example.ecommerce.entities.product.Category;
import com.example.ecommerce.services.product.CategoryService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping(path = "/getAvailableCategories")
    public ResponseEntity<List<Category>> getAvailableCategories()
    {
        return  new ResponseEntity<List<Category>>(categoryService.getAvailableCategories(), HttpStatus.OK);
    }

    @PostMapping("/createCategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category)
    {
        return new ResponseEntity<Category>(categoryService.updateCategory(category), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/category/updateImage/{categoryId}")
    public ResponseEntity<Boolean> updateImage(@PathVariable int categoryId, @RequestParam MultipartFile file)
    {
        return new ResponseEntity<Boolean>(categoryService.updateImage(categoryId, file), HttpStatus.ACCEPTED);
    }

    @GetMapping("/category/getImage/{categoryId}")
    public ResponseEntity<InputStreamResource> getImage(@PathVariable int categoryId) {
       HttpHeaders headers = new HttpHeaders();
       headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=categoryPic.jpg");
       return ResponseEntity.ok().headers(headers).contentType(MediaType.IMAGE_JPEG).body(categoryService.getImage(categoryId));
    }

    @PatchMapping("/validateCategory/{categoryId}")
    public ResponseEntity<Boolean> validateCategory(@PathVariable int categoryId)
    {
        return new ResponseEntity<Boolean>(categoryService.validateUnvalidateCategory(categoryId, true), HttpStatus.OK);
    }    
    
    @PatchMapping("/unvalidateCategory/{categoryId}")
    public ResponseEntity<Boolean> unvalidateCategory(@PathVariable int categoryId)
    {
        return new ResponseEntity<Boolean>(categoryService.validateUnvalidateCategory(categoryId, false), HttpStatus.OK);
    }

    @PatchMapping("/validateCategoryAndAllProducts/{categoryId}")
    public ResponseEntity<Boolean> validateCategoryAndAllProducts(@PathVariable int categoryId)
    {
        return new ResponseEntity<Boolean>(categoryService.validateUnvalidateCategoryAndAllProducts(categoryId, true), HttpStatus.OK);
    }

    @PatchMapping("/unvalidateCategoryAndAllProducts/{categoryId}")
    public ResponseEntity<Boolean> validateUnvalidateCategoryAndAllProducts(@PathVariable int categoryId)
    {
        return new ResponseEntity<Boolean>(categoryService.validateUnvalidateCategoryAndAllProducts(categoryId, false), HttpStatus.OK);
    }
}
