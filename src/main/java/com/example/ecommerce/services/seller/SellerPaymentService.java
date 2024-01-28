package com.example.ecommerce.services.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.seller.SellerPayment;
import com.example.ecommerce.repositories.seller.SellerPaymentRepository;

import java.util.List;

@Service
public class SellerPaymentService {
    @Autowired
    private SellerPaymentRepository sellerPaymentRepository;

    public List<SellerPayment> getAllSellerPayments()
    {
        return (List<SellerPayment>) sellerPaymentRepository.findAll();
    }

    public SellerPayment getSellerPaymentById(int sellerPaymentId)
    {
        return sellerPaymentRepository.findById(sellerPaymentId).orElseThrow(()->new RuntimeException("No seller payment exists with this id"));
    }
    
    public List<SellerPayment> getSellerPayemntBySellerId(int sellerId)
    {
        return sellerPaymentRepository.getSellerPaymentBySellerId(sellerId);
    }

    public SellerPayment getSellerPaymentByOrderItemId(int orderItemId)
    {
        return sellerPaymentRepository.getSellerPaymentByOrderItemId(orderItemId);
    }

    public List<SellerPayment> getSellerPaymentByProductId(int productId)
    {
        return sellerPaymentRepository.getSellerPaymentByProductId(productId);
    }

    public List<SellerPayment> getSellerPaymentByQuantity(int quantity)
    {
        return sellerPaymentRepository.getSellerPaymentByQuantity(quantity);
    }

    public List<SellerPayment> getSellerPaymentByPrice(double price)
    {
        return sellerPaymentRepository.getSellerPaymentByTotalPrice(price);
    }

    public List<SellerPayment> getSellerPaymentByBuyerId(int buyerId)
    {
        return sellerPaymentRepository.getSellerPaymentByBuyerId(buyerId);
    }

    public List<SellerPayment> getSellerPaymentByOrderId(int orderId)
    {
        return sellerPaymentRepository.getSellerPaymentByOrderId(orderId);
    }

    public List<SellerPayment> getSellerPaymentByTotalPrice(double totalPrice)
    {
        return sellerPaymentRepository.getSellerPaymentByTotalPrice(totalPrice);
    }

    public SellerPayment collectSellerPayment(int sellerPaymentId)
    {
        SellerPayment sp = getSellerPaymentById(sellerPaymentId);
        if(!sp.isCollected())
        {
            sp.setCollected(true);
            return sellerPaymentRepository.save(sp);
        }
        else
            throw new RuntimeException("The seller payment has already been collected");
            
    }
}
