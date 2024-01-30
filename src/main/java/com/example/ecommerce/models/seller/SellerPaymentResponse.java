package com.example.ecommerce.models.seller;

import com.example.ecommerce.entities.enums.ModeOfPayment;
import com.example.ecommerce.entities.seller.SellerPayment;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class SellerPaymentResponse {
    private int id;
    private ModeOfPayment modeOfPayment;
    private int buyerId;
    private int orderId;
    private int sellerId;
    private int orderItemId;
    private int quantity;
    private double price;
    private double totalPrice;
    private boolean collected;
    private int productId;
    private String productName;

    public SellerPaymentResponse(SellerPayment sellerPayment)
    {
        this.id=sellerPayment.getId();
        this.modeOfPayment=sellerPayment.getModeOfPayment();
        this.buyerId=sellerPayment.getBuyerId();
        this.orderId=sellerPayment.getOrderId();
        this.sellerId=sellerPayment.getSellerId();
        this.orderItemId=sellerPayment.getOrderItem().getId();
        this.quantity=sellerPayment.getQuantity();
        this.price=sellerPayment.getPrice();
        this.totalPrice=sellerPayment.getTotalPrice();
        this.collected=sellerPayment.isCollected();
        this.productId=sellerPayment.getProduct().getId();
        this.productName=sellerPayment.getProduct().getName();
    }
}
