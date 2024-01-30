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
import com.example.ecommerce.models.order.OrderPaymentResponse.OrderPaymentResponse;
import com.example.ecommerce.services.order.OrderPaymentService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class OrderPaymentController {
    @Autowired
    private OrderPaymentService orderPaymentService;
    
    @GetMapping("/getAllOrderPayments")
    public ResponseEntity<List<OrderPaymentResponse>> getAllOrderPayments() 
    {
        return new ResponseEntity<List<OrderPaymentResponse>>(orderPaymentService.getAllOrderPayments(), HttpStatus.OK);
    }

    @GetMapping("/getOrderPaymentById/{orderPaymentId}")
    public ResponseEntity<OrderPaymentResponse> getOrderPaymentById(@PathVariable int orderPaymentId) 
    {
        return new ResponseEntity<OrderPaymentResponse>(orderPaymentService.getOrderPaymentResponseById(orderPaymentId), HttpStatus.OK); 
    }
    
    @GetMapping("/getCompletedOrderPayments")
    public ResponseEntity<List<OrderPaymentResponse>> getCompletedOrderPayments() 
    {
        return new ResponseEntity<List<OrderPaymentResponse>>(orderPaymentService.getCompletedOrderPayments(), HttpStatus.OK);
    }
    
    @GetMapping("/getIncompleteOrderPayments")
    public ResponseEntity<List<OrderPaymentResponse>> getIncompleteOrderPayments() 
    {
        return new ResponseEntity<List<OrderPaymentResponse>>(orderPaymentService.getIncompleteOrderPayments(), HttpStatus.OK);
    }
    
    @PatchMapping("/completeOrderPayment")
    public ResponseEntity<OrderPayment> completeUserPayment(@RequestParam int orderPaymentId, @RequestParam ModeOfPayment modeOfPayment) {
        return new ResponseEntity<OrderPayment>(orderPaymentService.completeOrderPayment(orderPaymentId, modeOfPayment), HttpStatus.OK);
    }

    @GetMapping("/getOrderPaymentsByBuyerId/{buyerId}")
    public ResponseEntity<List<OrderPaymentResponse>> getOrderPaymentsByBuyerId(@PathVariable int buyerId) {
        return new ResponseEntity<List<OrderPaymentResponse>>(orderPaymentService.getOrderPaymentByBuyerId(buyerId), HttpStatus.OK);
    }
    
    @GetMapping("/getOrderPaymentsCompletedByBuyerId/{buyerId}")
    public ResponseEntity<List<OrderPaymentResponse>> getOrderPayementsCompletedByBuyerId(@PathVariable int buyerId) 
    {
        return new ResponseEntity<List<OrderPaymentResponse>>(orderPaymentService.getOrderPaymentsCompletedByBuyerId(buyerId), HttpStatus.OK);
    }

    @GetMapping("/getOrderPaymentsIncompletedByBuyerId/{buyerId}")
    public ResponseEntity<List<OrderPaymentResponse>> getOrderPaymentsIncompletedByBuyerId(@PathVariable int buyerId) 
    {
        return new ResponseEntity<List<OrderPaymentResponse>>(orderPaymentService.getOrderPaymentsIncompletedByBuyerId(buyerId), HttpStatus.OK);
    }
        
}
