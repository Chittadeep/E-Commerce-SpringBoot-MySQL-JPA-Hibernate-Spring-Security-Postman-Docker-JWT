package com.example.ecommerce.repositories.seller;

import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.enums.ModeOfPayment;
import com.example.ecommerce.entities.seller.SellerPayment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface SellerPaymentRepository extends CrudRepository<SellerPayment, Integer> {
    public List<SellerPayment> getSellerPaymentByModeOfPayment(ModeOfPayment modeOfPayment);
    
    public List<SellerPayment> getSellerPaymentBySellerId(int sellerId);

    public List<SellerPayment> getSellerPaymentByOrderItemId(int orderItemId);

    public List<SellerPayment> getSellerPaymentByProductId(int productId);
    
    public List<SellerPayment> getSellerPaymentByQuantity(int quantity);

    public List<SellerPayment> getSellerPaymentByPrice(double price);
}
