package com.example.ecommerce.entities.product;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.example.ecommerce.entities.seller.Seller;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Product cannot be created without price")
    private double price;
    @NotBlank(message = "Product cannot be created without quantity")
    private int quantity;
    @ColumnDefault(value = "true")
    private boolean available;

    @ManyToMany
    private List<Category> category;

    @OneToMany
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private List<ProductImage> images;
    
    @ManyToOne
    private Seller seller;
}
