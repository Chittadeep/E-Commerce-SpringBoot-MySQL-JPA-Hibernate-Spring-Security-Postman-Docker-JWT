package com.example.ecommerce.entities.seller;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.example.ecommerce.models.seller.SellerRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name of an Seller cannot be blank")
    private String name;
    @Size(min=10, max = 10, message = "phone number should be of 10 digits")
    @Column(unique = true)
    private String phoneNumber;
    @Email(message = "The email address is invalid")
    @Column(unique=true)
    private String mail;
    @Lob
    @Column(length=50000000)
    private byte[] image;
    @ColumnDefault(value = "true")
    private boolean valid;

    //foreign relations inverse side
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sellerId", referencedColumnName = "id")
    private List<SellerAddress> sellerAddresses; 

    public Seller(SellerRequest sellerRequest)
    {
        this.mail=sellerRequest.getMail();
        this.name=sellerRequest.getName();
        this.phoneNumber=sellerRequest.getPhoneNumber();
    }

    public Seller(){}
}
