package com.example.ecommerce.models.order;

import java.sql.Timestamp;

import java.util.List;

import com.example.ecommerce.entities.enums.OrderState;
import com.example.ecommerce.entities.order.OrderCustom;
import com.example.ecommerce.entities.order.OrderPayment;

import lombok.Data;

@Data
public class OrderResponse {
    private int orderId;
    private int buyerId;
    private List<OrderItemResponse> orderItems;
    private double basePrice;
    private double saasFee;
    private double deliveryPrice;
    private double totalPrice;
    private Timestamp orderInitiatedTimestamp;
    private Timestamp orderPlacedTimestamp;
    private OrderState orderState;
    private OrderPayment orderPayment;

    public OrderResponse(OrderCustom orderCustom)
    {
        this.orderId=orderCustom.getId();
        this.buyerId=orderCustom.getBuyer().getId();
        this.orderInitiatedTimestamp=orderCustom.getOrderInitiatedTimestamp();
        this.orderPlacedTimestamp = orderCustom.getOrderPlacedTimestamp();
        this.orderItems = orderCustom.getOrderItems().stream().map(OrderItemResponse::new).toList();
        this.deliveryPrice = orderCustom.getDeliveryPrice();
        this.basePrice = orderCustom.getBasePrice();
        this.saasFee = orderCustom.getSaasFee();
        this.totalPrice = orderCustom.getTotalPrice();
        this.orderState = orderCustom.getOrderState();
        this.orderPayment = orderCustom.getOrderPayment();
    }
}
