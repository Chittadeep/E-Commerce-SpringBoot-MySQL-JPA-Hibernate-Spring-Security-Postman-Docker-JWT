package com.example.ecommerce.entities.buyer;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import com.example.ecommerce.entities.order.OrderCustom;
import com.example.ecommerce.models.buyer.BuyerRequest;

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
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name of a Buyer cannot be blank")
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

    @OneToMany(mappedBy = "buyer")
    private List<OrderCustom> orders;
    //foreign relations inverse side
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="buyerId", referencedColumnName = "id")
    private List<BuyerAddress> buyerAddresses;

    public Buyer(BuyerRequest buyerRequest)
    {
        this.mail=buyerRequest.getMail();
        this.name=buyerRequest.getName();
        this.phoneNumber=buyerRequest.getPhoneNumber();
        this.valid=true;
    }

    public Buyer()
    {
    }
}
