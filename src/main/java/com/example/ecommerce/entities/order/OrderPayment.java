package com.example.ecommerce.entities.order;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CurrentTimestamp;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.enums.ModeOfPayment;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class OrderPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private ModeOfPayment modeOfPayment;
    @ColumnDefault(value = "false")
    private boolean completed;

    @CurrentTimestamp
    private Timestamp orderPaymentInitiated;
    private Timestamp orderPaymentCompleted;

    @JsonIgnore
    @OneToOne
    private OrderCustom orderCustom;

    @ManyToOne
    private Buyer buyer;
}
