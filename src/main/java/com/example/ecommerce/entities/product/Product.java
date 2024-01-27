package com.example.ecommerce.entities.product;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.example.ecommerce.entities.order.OrderItem;
import com.example.ecommerce.entities.seller.Seller;
import com.example.ecommerce.entities.seller.SellerAddress;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Product cannot be created without product name")
    private String name;
    @NotNull(message = "Product cannot be created without price")
    private double price;
    @NotNull(message = "Product cannot be created without quantity")
    private int quantity;
    @ColumnDefault(value = "true")
    private boolean available;

    @JsonIgnore
    @NotNull(message = "Product cannot be created without product category")
    @ManyToMany
    private List<Category> category;

    @OneToMany
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private List<ProductImage> images;
    
    @NotNull(message = "Product cannot be created without seller")
    @ManyToOne
    private Seller seller;

    @NotNull(message = "Product cannot be created without seller address")
    @ManyToOne
    private SellerAddress sellerAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviews;
}
