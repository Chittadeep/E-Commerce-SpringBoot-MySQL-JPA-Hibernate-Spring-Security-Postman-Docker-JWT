package com.example.ecommerce.repositories.product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.product.ProductImage;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Integer> {
    public List<ProductImage> getProductImageByProductId(int productId); 
}
