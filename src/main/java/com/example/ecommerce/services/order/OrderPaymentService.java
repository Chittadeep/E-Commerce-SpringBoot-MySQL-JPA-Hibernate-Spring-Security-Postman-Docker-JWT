package com.example.ecommerce.services.order;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.enums.ModeOfPayment;
import com.example.ecommerce.entities.order.OrderPayment;
import com.example.ecommerce.repositories.order.OrderPaymentRepository;

@Service
public class OrderPaymentService {
    private OrderPaymentRepository orderPaymentRepository;

    public OrderPayment getOrderPaymentById(int orderPaymentId)
    {
        return orderPaymentRepository.findById(orderPaymentId).orElseThrow(()->new RuntimeException("No order payment with this id exists"));
    }

    public OrderPayment createOrderPayment(OrderPayment orderPayment)
    {
        return orderPaymentRepository.save(orderPayment);
    }

    public OrderPayment completeOrderPayment(int orderPaymentId, ModeOfPayment modeOfPayment)
    {
        OrderPayment orderPayment = getOrderPaymentById(orderPaymentId);
        orderPayment.setModeOfPayment(modeOfPayment);
        orderPayment.setOrderPaymentCompleted(new Timestamp(System.currentTimeMillis()));
        orderPayment.setCompleted(true);
        return orderPaymentRepository.save(orderPayment);
    }

    public List<OrderPayment> getAllOrderPayments()
    {
        return (List<OrderPayment>) orderPaymentRepository.findAll();
    }

    public List<OrderPayment> getCompletedOrderPayments()
    {
        return orderPaymentRepository.getOrderPaymentCompleted();
    }
   
    
    public List<OrderPayment> getIncompleteOrderPayments()
    {
        return orderPaymentRepository.getOrderPaymentIncomplete();
    }
    
    
}
