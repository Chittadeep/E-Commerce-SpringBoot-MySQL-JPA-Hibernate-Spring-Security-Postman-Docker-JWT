package com.example.ecommerce.models.buyer;

import lombok.Data;

@Data
public class BuyerRequest {
    private String name;
    private String phoneNumber;
    private String mail;
    private String password;
}
