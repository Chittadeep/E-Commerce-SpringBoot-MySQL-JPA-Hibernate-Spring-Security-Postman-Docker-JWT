package com.example.ecommerce.services.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.seller.SellerPayment;
import com.example.ecommerce.models.seller.SellerPaymentResponse;
import com.example.ecommerce.repositories.seller.SellerPaymentRepository;

import java.util.List;

@Service
public class SellerPaymentService {
    @Autowired
    private SellerPaymentRepository sellerPaymentRepository;

    public List<SellerPaymentResponse> getAllSellerPayments()
    {
        return ((List<SellerPayment>) sellerPaymentRepository.findAll()).stream().map(SellerPaymentResponse::new).toList();
    }

    public SellerPaymentResponse getSellerPaymentResponseById(int sellerPaymentId)
    { 
        return new SellerPaymentResponse(getSellerPaymentById(sellerPaymentId));
    }

    private SellerPayment getSellerPaymentById(int sellerPaymentId)
    {
        return sellerPaymentRepository.findById(sellerPaymentId).orElseThrow(()->new RuntimeException("No seller payment exists with this id"));
    }
    
    public List<SellerPaymentResponse> getSellerPayemntBySellerId(int sellerId)
    {
        return sellerPaymentRepository.getSellerPaymentBySellerId(sellerId).stream().map(SellerPaymentResponse::new).toList();
    }

    public SellerPaymentResponse getSellerPaymentByOrderItemId(int orderItemId)
    {
        return new SellerPaymentResponse(sellerPaymentRepository.getSellerPaymentByOrderItemId(orderItemId));
    }

    public List<SellerPaymentResponse> getSellerPaymentByProductId(int productId)
    {
        return sellerPaymentRepository.getSellerPaymentByProductId(productId).stream().map(SellerPaymentResponse::new).toList();
    }

    public List<SellerPaymentResponse> getSellerPaymentByQuantity(int quantity)
    {
        return sellerPaymentRepository.getSellerPaymentByQuantity(quantity).stream().map(SellerPaymentResponse::new).toList();
    }

    public List<SellerPaymentResponse> getSellerPaymentByPrice(double price)
    {
        return sellerPaymentRepository.getSellerPaymentByPrice(price).stream().map(SellerPaymentResponse::new).toList();
    }

    public List<SellerPaymentResponse> getSellerPaymentByBuyerId(int buyerId)
    {
        return sellerPaymentRepository.getSellerPaymentByBuyerId(buyerId).stream().map(SellerPaymentResponse::new).toList();
    }

    public List<SellerPaymentResponse> getSellerPaymentByOrderId(int orderId)
    {
        return sellerPaymentRepository.getSellerPaymentByOrderId(orderId).stream().map(SellerPaymentResponse::new).toList();
    }

    public List<SellerPaymentResponse> getSellerPaymentByTotalPrice(double totalPrice)
    {
        return sellerPaymentRepository.getSellerPaymentByTotalPrice(totalPrice).stream().map(SellerPaymentResponse::new).toList();
    }

    public SellerPaymentResponse collectSellerPayment(int sellerPaymentId)
    {
        SellerPayment sp = getSellerPaymentById(sellerPaymentId);
        if(!sp.isCollected())
        {
            sp.setCollected(true);
            sellerPaymentRepository.save(sp);
            return getSellerPaymentResponseById(sellerPaymentId);
        }
        else
            throw new RuntimeException("The seller payment has already been collected");
            
    }

    public List<SellerPaymentResponse> getCollectedSellerPayments()
    {
        return sellerPaymentRepository.getCollectedSellerPayments().stream().map(SellerPaymentResponse::new).toList();
    }

    public List<SellerPaymentResponse> getUncollectedSellerPayments()
    {
        return sellerPaymentRepository.getUncollectedSellerPayments().stream().map(SellerPaymentResponse::new).toList();
    }
}
