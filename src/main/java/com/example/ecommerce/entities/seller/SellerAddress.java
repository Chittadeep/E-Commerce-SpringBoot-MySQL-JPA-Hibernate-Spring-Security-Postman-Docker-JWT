package com.example.ecommerce.entities.seller;

import java.util.List;

import com.example.ecommerce.entities.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class SellerAddress {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "city cannot be null for an address")
    private String city;
    @NotNull(message = "address cannot be null for an address")
    private String address;
    @NotNull(message = "state cannot be null for an address")
    private String state;
    @NotNull(message = "pincode cannot be null for an address")
    private String pincode;

    //sellerId ought to be mapped
    //foreign relations owning side
    @NotNull(message = "Seller address cannot be created without sellerID")
    private int sellerId;

    @OneToMany(mappedBy = "sellerAddress")
    private List<Product> products;
}
