package com.example.ecommerce.controllers.seller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entities.seller.SellerPayment;
import com.example.ecommerce.services.seller.SellerPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class SellerPaymentController {
    @Autowired
    private SellerPaymentService sellerPaymentService;
    
    @GetMapping("/getAllSellerPayments")
    public ResponseEntity<List<SellerPayment>> getAllSellerPayments() 
    {
        return new ResponseEntity<List<SellerPayment>>(sellerPaymentService.getAllSellerPayments(), HttpStatus.OK);
    }

    @GetMapping("/getSellerById/{sellerPaymentId}")
    public ResponseEntity<SellerPayment> getSellerPaymentById(@PathVariable int sellerPaymentId)
    {
        return new ResponseEntity<SellerPayment>(sellerPaymentService.getSellerPaymentById(sellerPaymentId), HttpStatus.OK);
    }

    @GetMapping("/getSellerPaymentBySellerId/{sellerId}")
    public ResponseEntity<SellerPayment> getMethodName(@PathVariable int sellerId) {
        return new ResponseEntity<SellerPayment>(sellerPaymentService.collectSellerPayment(sellerId), HttpStatus.OK);
    }
    

    @GetMapping("/getSellerPaymentByOrderItemId/{orderItemId}")
    public ResponseEntity<SellerPayment> getSellerPaymentByOrderItemId(@PathVariable int orderItemId) 
    {
        return new ResponseEntity<SellerPayment>(sellerPaymentService.getSellerPaymentByOrderItemId(orderItemId), HttpStatus.OK);
    }
    
    @GetMapping("/getSellerPaymentByProductId/{productId}")
    public ResponseEntity<List<SellerPayment>> getSellerPaymentByProductId(@PathVariable int productId) 
    {
        return new ResponseEntity<List<SellerPayment>>(sellerPaymentService.getSellerPaymentByProductId(productId), HttpStatus.OK);
    }

    @GetMapping("/getSellerPaymentByQuantity/{quantity}")
    public ResponseEntity<List<SellerPayment>> getSellerPaymentByQuantity(@PathVariable int quantity) 
    {
        return new ResponseEntity<List<SellerPayment>>(sellerPaymentService.getSellerPaymentByQuantity(quantity), HttpStatus.OK);
    }
    
    @GetMapping("/getSellerPaymentByPrice/{price}")
    public ResponseEntity<List<SellerPayment>> getSellerPaymentByPrice(@PathVariable double price) 
    {
        return new ResponseEntity<List<SellerPayment>>(sellerPaymentService.getSellerPaymentByPrice(price), HttpStatus.OK);
    }

    @GetMapping("/getSellerPaymentByBuyerId/{buyerId}")
    public ResponseEntity<List<SellerPayment>> getSellerPaymentByBuyerId(@PathVariable int buyerId) 
    {
        return new ResponseEntity<List<SellerPayment>>(sellerPaymentService.getSellerPaymentByBuyerId(buyerId), HttpStatus.OK);
    }
    
    @GetMapping("/getSellerPaymentByOrderId/{orderId}")
    public ResponseEntity<List<SellerPayment>> getSellerPaymentByOrderId(@PathVariable int orderId) 
    {
        return new ResponseEntity<List<SellerPayment>>(sellerPaymentService.getSellerPaymentByOrderId(orderId), HttpStatus.OK);
    }

    @GetMapping("/getSellerPaymentByTotalPrice/{totalPrice}")
    public ResponseEntity<List<SellerPayment>> getSellerPaymentByTotalPrice(double totalPrice)
    {
        return new ResponseEntity<List<SellerPayment>>(sellerPaymentService.getSellerPaymentByTotalPrice(totalPrice), HttpStatus.OK);
    }
    
    @PatchMapping("/collectSellerPayment/{sellerPaymentId}")
    public ResponseEntity<SellerPayment> collectSellerPayment(@PathVariable int sellerPaymentId) 
    {
        return new ResponseEntity<SellerPayment>(sellerPaymentService.collectSellerPayment(sellerPaymentId), HttpStatus.OK);
    }
    
}
