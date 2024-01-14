package com.example.ecommerce.repositories.order;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.ecommerce.entities.enums.OrderState;
import com.example.ecommerce.entities.order.OrderCustom;

public interface OrderRepository extends CrudRepository<OrderCustom, Integer> {
    public List<OrderCustom> getOrderCustomByBuyerId(int buyerId);
    
    public List<OrderCustom> getOrderCustomByBasePrice(double basePrice);

    public List<OrderCustom> getOrderCustomByDeliveryPrice(double deliveryPrice);

    public List<OrderCustom> getOrderCustomByTotalPrice(double totalPrice);

    public List<OrderCustom> getOrderCustomByOrderState(OrderState orderState);

    public List<OrderCustom> getOrderCustomBySaasFee(double saasFee);
}
