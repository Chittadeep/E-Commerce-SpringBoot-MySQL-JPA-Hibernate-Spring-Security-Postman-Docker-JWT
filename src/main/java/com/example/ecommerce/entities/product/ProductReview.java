package com.example.ecommerce.entities.product;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.order.OrderCustom;
import com.example.ecommerce.entities.order.OrderItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    @NotNull(message = "Product review cannot be created without review")
    @Max(5)
    @Min(0)
    private int stars;

    @NotNull(message = "Product review cannot be given without buyer")
    @ManyToOne
    private Buyer buyer;

    @NotNull(message = "Product review cannot be given without comments")
    @OneToOne
    private OrderItem orderItem;

    @NotNull(message = "Product review cannot be given without the product")
    @ManyToOne
    private Product product;

}
