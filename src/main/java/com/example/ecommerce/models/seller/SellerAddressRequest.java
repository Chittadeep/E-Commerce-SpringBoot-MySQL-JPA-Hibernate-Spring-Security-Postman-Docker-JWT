package com.example.ecommerce.models.seller;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SellerAddressRequest {
    private String city;
    private String address;
    private String state;
    private String pincode;
}
