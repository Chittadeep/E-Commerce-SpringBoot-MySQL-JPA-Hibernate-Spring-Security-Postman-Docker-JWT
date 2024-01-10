package com.example.ecommerce.entities.product;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "Category cannot be created without name")
    @Column(unique = true)
    private String name;
    @ColumnDefault(value = "true")
    private boolean available;
    @Lob
    @Column(length =50000000)
    private byte[] image;
    
    @NotNull(message = "Category cannot be created qwithout seller id")
    private int sellerId;

    @ManyToMany(mappedBy = "category", cascade=CascadeType.ALL)
    private List<Product> products;

}
