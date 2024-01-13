package com.example.ecommerce.models.product;



import com.example.ecommerce.entities.product.Product;

import lombok.Data;

@Data
public class ProductResponse {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private boolean available;
    private int sellerId;
    private int sellerAddressId;

    public ProductResponse(Product product)
    {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.available = product.isAvailable();
        this.sellerId = product.getSeller().getId();
        this.sellerAddressId = product.getSeller().getId();
    }
}
