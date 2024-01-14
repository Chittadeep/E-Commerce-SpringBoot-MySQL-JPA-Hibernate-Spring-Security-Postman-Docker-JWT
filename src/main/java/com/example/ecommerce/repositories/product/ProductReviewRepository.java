package com.example.ecommerce.repositories.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.ecommerce.entities.product.ProductReview;

@Repository
public interface ProductReviewRepository extends CrudRepository<ProductReview, Integer>{
    public List<ProductReview> getProductReviewByStars(int stars);

    public List<ProductReview> getProductReviewByBuyerId(int buyerId);

    public List<ProductReview> getProductReviewByOrderItemId(int ordeItemId);

    public List<ProductReview> getProductReviewByProductId(int productId);
}
