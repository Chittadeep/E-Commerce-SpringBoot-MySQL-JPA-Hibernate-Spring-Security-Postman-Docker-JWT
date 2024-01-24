package com.example.ecommerce.services.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entities.enums.OrderState;
import com.example.ecommerce.entities.order.OrderCustom;
import com.example.ecommerce.repositories.order.OrderRepository;


@RestController
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderCustom> getAllOrders() 
    {
        return (List<OrderCustom>) orderRepository.findAll();
    }

    public OrderCustom createOrderCustom(OrderCustom order) 
    {
        return orderRepository.save(order);
    }

    public OrderCustom updateOrderCustom(OrderCustom order)
    {
        getOrderCustomById(order.getId());
        return orderRepository.save(order);
    }
    
    public OrderCustom getOrderCustomById(int orderId)
    {
        return orderRepository.findById(orderId).orElseThrow(()-> new RuntimeException("Order with this Id does not exist"));
    }

    public List<OrderCustom> getOrderCustomByBuyerId(int buyerId)
    {
        return orderRepository.getOrderCustomByBuyerId(buyerId);
    }

    public List<OrderCustom> getOrderCustomByBasePrice(double basePrice)
    {
        return orderRepository.getOrderCustomByBasePrice(basePrice);
    }

    public List<OrderCustom> getOrderCustomByDeliveryPrice(double deliveryPrice)
    {
        return orderRepository.getOrderCustomByDeliveryPrice(deliveryPrice);
    }

    public List<OrderCustom> getOrderCustomByTotalPrice(double totalPrice)
    {
        return orderRepository.getOrderCustomByTotalPrice(totalPrice);
    }

    public List<OrderCustom> getOrderCustomByOrderState(OrderState orderState)
    {
        return orderRepository.getOrderCustomByOrderState(orderState);
    }

    public List<OrderCustom> getOrderCustomBySaasFee(double saasFee)
    {
        return orderRepository.getOrderCustomBySaasFee(saasFee);
    }
}
