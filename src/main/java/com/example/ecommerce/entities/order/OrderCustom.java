package com.example.ecommerce.entities.order;

import java.util.List;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.enums.OrderState;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class OrderCustom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @NotNull(message = "Order cannot be created without basePrice")
    private double basePrice;
    @NotNull(message = "Order cannot be created without deliveryPrice")
    private double deliveryPrice;
    @NotNull(message = "Order cannot be created without totalPrice")
    private double totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    @NotNull(message = "Order cannot be created without saasFee")
    private double saasFee;

    @ManyToOne
    private Buyer buyer;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
