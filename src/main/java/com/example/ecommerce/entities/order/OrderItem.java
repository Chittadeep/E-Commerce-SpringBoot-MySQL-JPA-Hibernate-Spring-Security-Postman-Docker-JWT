package com.example.ecommerce.entities.order;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.product.Product;
import com.example.ecommerce.entities.product.ProductReview;
import com.example.ecommerce.entities.seller.SellerPayment;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private double totalPrice;

    
    @NotNull(message = "order item cannot be created without product")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    
    @JsonIgnore
    @ManyToOne
    private OrderCustom order;

    @JsonIgnore
    @ManyToOne
    private Buyer buyer;

    @OneToOne(mappedBy = "orderItem")
    private SellerPayment sellerPayment;
    
    @OneToOne(mappedBy="orderItem")
    private ProductReview productReview; 
}
