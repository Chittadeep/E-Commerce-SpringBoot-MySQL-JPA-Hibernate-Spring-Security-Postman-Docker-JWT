package com.example.ecommerce.services.order;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.enums.ModeOfPayment;
import com.example.ecommerce.entities.enums.OrderState;
import com.example.ecommerce.entities.order.OrderItem;
import com.example.ecommerce.entities.order.OrderPayment;
import com.example.ecommerce.entities.seller.SellerPayment;
import com.example.ecommerce.repositories.order.OrderPaymentRepository;
import com.example.ecommerce.repositories.seller.SellerPaymentRepository;

@Service
public class OrderPaymentService {
    @Autowired
    private OrderPaymentRepository orderPaymentRepository;
    @Autowired
    private SellerPaymentRepository sellerPaymentRepository;

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
        orderPayment.getOrderCustom().setOrderState(OrderState.CONFIRMED);
        orderPayment.getOrderCustom().setOrderPlacedTimestamp(new Timestamp(System.currentTimeMillis()));
        List<OrderItem> orderItems = orderPayment.getOrderCustom().getOrderItems();
        orderItems.forEach(orderItem->{
            SellerPayment sellerPayment = new SellerPayment();
            sellerPayment.setBuyerId(orderItem.getOrder().getBuyer().getId());
            sellerPayment.setOrderId(orderItem.getOrder().getId());
            sellerPayment.setSellerId(orderItem.getProduct().getSeller().getId());
            sellerPayment.setModeOfPayment(ModeOfPayment.INITIATED);
            sellerPayment.setOrderItem(orderItem);
            sellerPayment.setPrice(orderItem.getPrice());
            sellerPayment.setProduct(orderItem.getProduct());
            sellerPayment.setQuantity(orderItem.getQuantity());
            sellerPayment.setTotalPrice(orderItem.getPrice()*orderItem.getQuantity());
            sellerPaymentRepository.save(sellerPayment);
        });
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
