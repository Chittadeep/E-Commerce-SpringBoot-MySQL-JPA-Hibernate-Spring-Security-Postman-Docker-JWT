package com.example.ecommerce.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.example.ecommerce.entities.product.ProductReview;
import com.example.ecommerce.repositories.product.ProductRepository;
import com.example.ecommerce.repositories.product.ProductReviewRepository;

@Service
public class ProductReviewService {
    @Autowired
    private ProductReviewRepository productReviewRepository;

    public List<ProductReview> getAllProductReview()
    {
        return (List<ProductReview>) productReviewRepository.findAll();
    }

    public ProductReview createProductReview(ProductReview productReview)
    {
        return productReviewRepository.save(productReview);
    }

    public ProductReview updateProductReview(ProductReview productReview)
    {
        getProductReviewById(productReview.getId());
        return productReviewRepository.save(productReview);
    }

    public boolean deleteProductReview(int productReviewId)
    {
        getProductReviewById(productReviewId);
        productReviewRepository.deleteById(productReviewId);
        return true;
    }

    public ProductReview getProductReviewById(int productReviewId)
    {
        return productReviewRepository.findById(productReviewId).orElseThrow(()-> new RuntimeException("Product review with this id does not exist"));
    }

    public List<ProductReview> getProductReviewByStars(int stars)
    {
        return productReviewRepository.getProductReviewByStars(stars);
    }

    public List<ProductReview> getProductReviewByBuyerId(int buyerId)
    {
        return productReviewRepository.getProductReviewByBuyerId(buyerId);
    }

    public List<ProductReview> getProductReviewByOrderId(int orderId)
    {
        return productReviewRepository.getProductReviewByOrderItemId(orderId);
    }

    public List<ProductReview> getProductReviewByProductId(int productId)
    {
        return productReviewRepository.getProductReviewByProductId(productId);
    }
}
