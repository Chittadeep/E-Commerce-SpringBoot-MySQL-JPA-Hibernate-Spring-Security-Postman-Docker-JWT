package com.example.ecommerce.entities.product;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

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
    private String name;
    @ColumnDefault(value = "true")
    private boolean available;
    @Lob
    @Column(length =50000000)
    private byte[] image;

    @ManyToMany(mappedBy = "category")
    private List<Product> product;
    
}
