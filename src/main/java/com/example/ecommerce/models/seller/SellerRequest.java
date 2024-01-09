package com.example.ecommerce.models.seller;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SellerRequest {    
    private String name;
    private String phoneNumber;
    private String mail;
    private String password;
}
