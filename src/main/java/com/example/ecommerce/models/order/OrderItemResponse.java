package com.example.ecommerce.models.order;

import com.example.ecommerce.entities.order.OrderItem;
import com.example.ecommerce.entities.seller.SellerAddress;

import lombok.Data;

@Data
public class OrderItemResponse {
    private int orderItemId;   
    private String productName;
    private int quantity;
    private double price;
    private double totalPrice;
    private int productId;
    private int sellerId;
    private int sellerAddressId;
    private String sellerName;
    private String sellerAddress;

    public OrderItemResponse(OrderItem orderItem)
    {
        this.orderItemId = orderItem.getId();
        this.productName=orderItem.getProduct().getName();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
        this.totalPrice = orderItem.getPrice();
        this.productId = orderItem.getProduct().getId();
        this.sellerId = orderItem.getProduct().getSeller().getId();
        this.sellerAddressId = orderItem.getProduct().getSellerAddress().getId();
        this.sellerName = orderItem.getProduct().getSeller().getName();
        SellerAddress sa = orderItem.getProduct().getSellerAddress();
        this.sellerAddress = sa.getAddress()+" "+sa.getCity()+" "+sa.getPincode()+" "+sa.getState();
    }
}
