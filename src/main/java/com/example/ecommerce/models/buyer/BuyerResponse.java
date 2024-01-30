package com.example.ecommerce.models.buyer;

import java.util.List;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.buyer.BuyerAddress;

import lombok.Data;

@Data
public class BuyerResponse {
    private String name;
    private String phoneNumber;
    private String mail;
    private byte[] image;
    private boolean valid;
    private List<BuyerAddress> buyerAddress;

    public BuyerResponse(Buyer buyer)
    {
        this.name=buyer.getName();
        this.phoneNumber=buyer.getPhoneNumber();
        this.mail=buyer.getMail();
        this.image=buyer.getImage();
        this.valid = buyer.isValid();
        this.buyerAddress = buyer.getBuyerAddresses();
    }
}
