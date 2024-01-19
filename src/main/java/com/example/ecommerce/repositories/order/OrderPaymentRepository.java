package com.example.ecommerce.repositories.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.ecommerce.entities.enums.ModeOfPayment;
import com.example.ecommerce.entities.order.OrderPayment;


@Repository
public interface OrderPaymentRepository extends CrudRepository<OrderPayment, Integer>{

    public List<OrderPayment> getOrderPaymentByOrderCustomId(int orderCustomId);

    public List<OrderPayment> getOrderPaymentByModeOfPayment(ModeOfPayment modeOfPayment);

    @Query("Select o from OrderPayment as o where o.completed = true")
    public List<OrderPayment> getOrderPaymentCompleted();

    
    @Query("Select o from OrderPayment as o where o.completed = false")
    public List<OrderPayment> getOrderPaymentIncomplete();
} 
