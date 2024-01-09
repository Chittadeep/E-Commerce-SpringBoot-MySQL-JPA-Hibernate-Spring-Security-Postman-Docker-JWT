package com.example.ecommerce.entities.globals;

import javax.management.relation.Role;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ecommerce.entities.enums.Roles;
import com.example.ecommerce.models.buyer.BuyerRequest;
import com.example.ecommerce.models.seller.SellerRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
public class LoginDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "LoginDetails cannot be created without mail")
    private String mail;
    @NotBlank(message = "LoginDetails cannot be created without pasword")
    private String password;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Roles role;


    public LoginDetails(SellerRequest sellerRequest)
    {
        this.mail=sellerRequest.getMail();
        this.password =sellerRequest.getPassword();
        this.role=Roles.SELLER;
    }

    public LoginDetails(BuyerRequest buyerRequest)
    {
        this.mail = buyerRequest.getMail();
        this.password=buyerRequest.getPassword();
        this.role = Roles.BUYER;
    }
}
