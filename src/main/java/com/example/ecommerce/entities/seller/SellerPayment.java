package com.example.ecommerce.entities.seller;

import com.example.ecommerce.entities.enums.ModeOfPayment;
import com.example.ecommerce.entities.order.OrderItem;
import com.example.ecommerce.entities.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class SellerPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private ModeOfPayment modeOfPayment;
    //@NotNull(message = "Seller payment cannot be created without seller id")
    private int buyerId;
    private int orderId;
    private int sellerId;
    @OneToOne
    private OrderItem orderItem;
    @ManyToOne
    private Product product;
    private int quantity;
    private double price;
    private double totalPrice;
    private boolean collected;
}
