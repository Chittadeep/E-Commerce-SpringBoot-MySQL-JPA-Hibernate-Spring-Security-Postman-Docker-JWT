package com.example.ecommerce.models.product;

import com.example.ecommerce.entities.product.ProductReview;

import lombok.Data;

@Data
public class ProductReviewResponse {
    private int id;
    private String comment;
    private int stars;
    private int buyerId;
    private int orderItemId;
    private int productId;

    public ProductReviewResponse(ProductReview productReview)
    {
        this.id = productReview.getId();
        this.comment = productReview.getComment();
        this.stars = productReview.getStars();
        this.buyerId = productReview.getBuyer().getId();
        this.orderItemId=productReview.getOrderItem().getId();
        this.productId=productReview.getProduct().getId();
    }
}
