package com.example.ecommerce.entities.order;

import java.util.List;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CurrentTimestamp;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.buyer.BuyerAddress;
import com.example.ecommerce.entities.enums.OrderState;
import com.example.ecommerce.entities.product.ProductReview;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class OrderCustom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private double basePrice;
    private double deliveryPrice;
    private double totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    private double saasFee;

    @CurrentTimestamp
    private Timestamp orderInitiatedTimestamp; 
    private Timestamp orderPlacedTimestamp;

    @NotNull(message = "Order cannot be created without Buyer")
    @ManyToOne
    private Buyer buyer;

    @NotNull(message = "Order cannot be created without Buyer Address")
    @ManyToOne
    private BuyerAddress buyerAddress;

    @NotNull(message = "Order cannot be created without order items")
    @OneToMany(mappedBy = "order", cascade=CascadeType.ALL)
    private List<OrderItem> orderItems;

    @OneToOne(mappedBy = "orderCustom", cascade = CascadeType.ALL)
    private OrderPayment orderPayment;

}
