package com.example.ecommerce.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.order.OrderItem;
import com.example.ecommerce.entities.product.Product;
import com.example.ecommerce.entities.product.ProductReview;
import com.example.ecommerce.models.product.ProductReviewResponse;
import com.example.ecommerce.repositories.buyer.BuyerRepository;
import com.example.ecommerce.repositories.order.OrderItemRepository;
import com.example.ecommerce.repositories.product.ProductRepository;
import com.example.ecommerce.repositories.product.ProductReviewRepository;

@Service
public class ProductReviewService {
    @Autowired
    private ProductReviewRepository productReviewRepository;
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<ProductReviewResponse> getAllProductReview()
    {
        return ((List<ProductReview>) productReviewRepository.findAll()).stream().map(ProductReviewResponse::new).toList();
    }

    public ProductReviewResponse createProductReview(ProductReview productReview)
    {
        Buyer buyer = buyerRepository.findById(productReview.getBuyer().getId()).orElseThrow(()->new RuntimeException("No Buyer exists with this identity"));
        OrderItem orderItem = orderItemRepository.findById(productReview.getOrderItem().getId()).orElseThrow(()-> new RuntimeException("No order item exists with this identity"));
        Product product = productRepository.findById(productReview.getProduct().getId()).orElseThrow(()->new RuntimeException("No product exists with this identity"));
        if(orderItem.getBuyer().getId()!=buyer.getId())
            throw new RuntimeException("The order item does not belong to the buyer");
        if(orderItem.getProduct().getId()!=product.getId())
            throw new RuntimeException("The order item has not the same product id");
        productReviewRepository.save(productReview);
        return new ProductReviewResponse(productReview);
    }

    public ProductReviewResponse updateProductReview(ProductReview productReview)
    {
        ProductReview oldProductReview= getProductReviewById(productReview.getId());
        if(oldProductReview.getBuyer().getId()!=productReview.getBuyer().getId())
            throw new RuntimeException("The product review Buyer id cannot be changed");
        if(oldProductReview.getProduct().getId()!=productReview.getProduct().getId())
            throw new RuntimeException("The product review Product id cannot be changed");
        if(oldProductReview.getOrderItem().getId()!=productReview.getOrderItem().getId())
            throw new RuntimeException("The product review Order Item id cannot be changed");
        productReviewRepository.save(productReview);
        return new ProductReviewResponse(productReview);
    }

    public boolean deleteProductReview(int productReviewId)
    {
        getProductReviewById(productReviewId);
        productReviewRepository.deleteById(productReviewId);
        return true;
    }

    public ProductReviewResponse getProductReviewResponseById(int productReviewId)
    {
        return new ProductReviewResponse(getProductReviewById(productReviewId));
    }

    private ProductReview getProductReviewById(int productReviewId)
    {
        return productReviewRepository.findById(productReviewId).orElseThrow(()-> new RuntimeException("Product review with this id does not exist"));
    }

    public List<ProductReviewResponse> getProductReviewByStars(int stars)
    {
        return productReviewRepository.getProductReviewByStars(stars).stream().map(ProductReviewResponse::new).toList();
    }

    public List<ProductReviewResponse> getProductReviewByBuyerId(int buyerId)
    {
        return productReviewRepository.getProductReviewByBuyerId(buyerId).stream().map(ProductReviewResponse::new).toList();
    }

    public List<ProductReviewResponse> getProductReviewByOrderItemId(int orderItemId)
    {
        return productReviewRepository.getProductReviewByOrderItemId(orderItemId).stream().map(ProductReviewResponse::new).toList();
    }

    public List<ProductReviewResponse> getProductReviewByProductId(int productId)
    {
        return productReviewRepository.getProductReviewByProductId(productId).stream().map(ProductReviewResponse::new).toList();
    }
}
