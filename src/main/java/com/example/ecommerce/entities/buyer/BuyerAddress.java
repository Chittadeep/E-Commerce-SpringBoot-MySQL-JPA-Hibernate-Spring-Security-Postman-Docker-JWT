package com.example.ecommerce.entities.buyer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
public class BuyerAddress {
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

    @NotNull
    private int buyerId;

}
