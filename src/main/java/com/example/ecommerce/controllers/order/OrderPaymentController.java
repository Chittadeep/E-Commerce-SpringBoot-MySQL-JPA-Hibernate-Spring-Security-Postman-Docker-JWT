package com.example.ecommerce.controllers.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entities.enums.ModeOfPayment;
import com.example.ecommerce.entities.order.OrderPayment;
import com.example.ecommerce.services.order.OrderPaymentService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class OrderPaymentController {
    @Autowired
    private OrderPaymentService orderPaymentService;
    
    @GetMapping("/getAllOrderPayments")
    public ResponseEntity<List<OrderPayment>> getAllOrderPayments() 
    {
        return new ResponseEntity<List<OrderPayment>>(orderPaymentService.getAllOrderPayments(), HttpStatus.OK);
    }

    @GetMapping("/getOrderPaymentById/{orderPaymentId}")
    public ResponseEntity<OrderPayment> getOrderPaymentById(@PathVariable int orderPaymentId) 
    {
        return new ResponseEntity<OrderPayment>(orderPaymentService.getOrderPaymentById(orderPaymentId), HttpStatus.OK); 
    }
    
    @GetMapping("/getCompletedOrderPayments")
    public ResponseEntity<List<OrderPayment>> getCompletedOrderPayments() 
    {
        return new ResponseEntity<List<OrderPayment>>(orderPaymentService.getCompletedOrderPayments(), HttpStatus.OK);
    }
    
    @GetMapping("/getIncompleteOrderPayments")
    public ResponseEntity<List<OrderPayment>> getIncompleteOrderPayments() 
    {
        return new ResponseEntity<List<OrderPayment>>(orderPaymentService.getIncompleteOrderPayments(), HttpStatus.OK);
    }
    
    @PatchMapping("/completeOrderPayment")
    public ResponseEntity<OrderPayment> completeUserPayment(@RequestParam int orderPaymentId, @RequestParam ModeOfPayment modeOfPayment) {
        return new ResponseEntity<OrderPayment>(orderPaymentService.completeOrderPayment(orderPaymentId, modeOfPayment), HttpStatus.OK);
    }
    
}
