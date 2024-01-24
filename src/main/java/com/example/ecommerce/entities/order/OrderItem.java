package com.example.ecommerce.entities.order;

import com.example.ecommerce.entities.product.Product;
import com.example.ecommerce.entities.product.ProductReview;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message="order item cannot be created without quantity")
    private int quantity;

    private double price;

    @NotNull(message = "order item cannot be created without product")
    @ManyToOne
    private Product product;
    
    @ManyToOne
    private OrderCustom order;
    
    @OneToOne(mappedBy="orderItem")
    private ProductReview productReview; 
}
