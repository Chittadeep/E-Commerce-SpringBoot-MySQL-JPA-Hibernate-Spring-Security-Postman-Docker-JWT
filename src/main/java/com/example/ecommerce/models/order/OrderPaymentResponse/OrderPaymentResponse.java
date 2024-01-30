package com.example.ecommerce.models.order.OrderPaymentResponse;

import java.sql.Timestamp;

import com.example.ecommerce.entities.enums.ModeOfPayment;
import com.example.ecommerce.entities.order.OrderPayment;
import com.example.ecommerce.models.buyer.BuyerResponse;
import com.example.ecommerce.models.order.OrderResponse;

import lombok.Data;

@Data
public class OrderPaymentResponse {
    private int id;
    private ModeOfPayment modeOfPayment;
    private boolean completed;
    private Timestamp orderPaymentInititated;
    private Timestamp orderPaymentCompleted;
    private int orderId;
    private int buyerId;

    public OrderPaymentResponse(OrderPayment orderPayment){
        this.id=orderPayment.getId();
        this.modeOfPayment = orderPayment.getModeOfPayment();
        this.completed=orderPayment.isCompleted();
        this.orderPaymentInititated=orderPayment.getOrderPaymentInitiated();
        this.orderPaymentCompleted=orderPayment.getOrderPaymentCompleted();
        this.orderId=orderPayment.getOrderCustom().getId();
        this.buyerId=orderPayment.getBuyer().getId();
    }

}
