package com.example.ecommerce.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import com.example.ecommerce.entities.product.Category;
import com.example.ecommerce.entities.product.Product;
import com.example.ecommerce.repositories.product.CategoryRepository;
import com.example.ecommerce.repositories.product.ProductRepository;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

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

    public boolean updateImage(int categoryId ,MultipartFile file)
    {
        Category category = getCategoryById(categoryId);
        try{
        category.setImage(file.getBytes());
        categoryRepository.save(category);
        return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public InputStreamResource getImage(int categoryId)
    {
        Category category = getCategoryById(categoryId);
        byte[] bytes = category.getImage();
        if(bytes==null) throw new RuntimeException("The image you requested does not exist");
        InputStream inputStream = new ByteArrayInputStream(bytes);
        InputStreamResource resource = new InputStreamResource(inputStream);
        return resource;
    }

    public boolean validateUnvalidateCategory(int categoryId, boolean validation)
    {
        Category category = getCategoryById(categoryId);
        category.setAvailable(validation);
        categoryRepository.save(category);
        return true;
    }

    public boolean validateUnvalidateCategoryAndAllProducts(int categoryId, boolean validation)
    {
        validateUnvalidateCategory(categoryId, validation);
        List<Product> products = productRepository.getProductByCategoryId(categoryId);
        products.forEach(product->{
            product.setAvailable(validation);
            productRepository.save(product);
        }
        );
        return true;
    }
}
