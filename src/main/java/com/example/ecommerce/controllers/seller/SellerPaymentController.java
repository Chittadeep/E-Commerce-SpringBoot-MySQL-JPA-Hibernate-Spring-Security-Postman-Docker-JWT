package com.example.ecommerce.controllers.seller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entities.seller.SellerPayment;
import com.example.ecommerce.models.seller.SellerPaymentResponse;
import com.example.ecommerce.services.seller.SellerPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class SellerPaymentController {
    @Autowired
    private SellerPaymentService sellerPaymentService;
    
    @GetMapping("/getAllSellerPayments")
    public ResponseEntity<List<SellerPaymentResponse>> getAllSellerPayments() 
    {
        return new ResponseEntity<List<SellerPaymentResponse>>(sellerPaymentService.getAllSellerPayments(), HttpStatus.OK);
    }

    @GetMapping("/getSellerPaymentById/{sellerPaymentId}")
    public ResponseEntity<SellerPaymentResponse> getSellerPaymentById(@PathVariable int sellerPaymentId)
    {
        return new ResponseEntity<SellerPaymentResponse>(sellerPaymentService.getSellerPaymentResponseById(sellerPaymentId), HttpStatus.OK);
    }

    @GetMapping("/getSellerPaymentBySellerId/{sellerId}")
    public ResponseEntity<SellerPaymentResponse> getSellerPaymentBySellerId(@PathVariable int sellerId) {
        return new ResponseEntity<SellerPaymentResponse>(sellerPaymentService.collectSellerPayment(sellerId), HttpStatus.OK);
    }
    
    @GetMapping("/getSellerPaymentByOrderItemId/{orderItemId}")
    public ResponseEntity<SellerPaymentResponse> getSellerPaymentByOrderItemId(@PathVariable int orderItemId) 
    {
        return new ResponseEntity<SellerPaymentResponse>(sellerPaymentService.getSellerPaymentByOrderItemId(orderItemId), HttpStatus.OK);
    }
    
    @GetMapping("/getSellerPaymentByProductId/{productId}")
    public ResponseEntity<List<SellerPaymentResponse>> getSellerPaymentByProductId(@PathVariable int productId) 
    {
        return new ResponseEntity<List<SellerPaymentResponse>>(sellerPaymentService.getSellerPaymentByProductId(productId), HttpStatus.OK);
    }

    @GetMapping("/getSellerPaymentByQuantity/{quantity}")
    public ResponseEntity<List<SellerPaymentResponse>> getSellerPaymentByQuantity(@PathVariable int quantity) 
    {
        return new ResponseEntity<List<SellerPaymentResponse>>(sellerPaymentService.getSellerPaymentByQuantity(quantity), HttpStatus.OK);
    }
    
    @GetMapping("/getSellerPaymentByPrice/{price}")
    public ResponseEntity<List<SellerPaymentResponse>> getSellerPaymentByPrice(@PathVariable double price) 
    {
        return new ResponseEntity<List<SellerPaymentResponse>>(sellerPaymentService.getSellerPaymentByPrice(price), HttpStatus.OK);
    }

    @GetMapping("/getSellerPaymentByBuyerId/{buyerId}")
    public ResponseEntity<List<SellerPaymentResponse>> getSellerPaymentByBuyerId(@PathVariable int buyerId) 
    {
        return new ResponseEntity<List<SellerPaymentResponse>>(sellerPaymentService.getSellerPaymentByBuyerId(buyerId), HttpStatus.OK);
    }
    
    @GetMapping("/getSellerPaymentByOrderId/{orderId}")
    public ResponseEntity<List<SellerPaymentResponse>> getSellerPaymentByOrderId(@PathVariable int orderId) 
    {
        return new ResponseEntity<List<SellerPaymentResponse>>(sellerPaymentService.getSellerPaymentByOrderId(orderId), HttpStatus.OK);
    }

    @GetMapping("/getSellerPaymentByTotalPrice/{totalPrice}")
    public ResponseEntity<List<SellerPaymentResponse>> getSellerPaymentByTotalPrice(@PathVariable double totalPrice)
    {
        return new ResponseEntity<List<SellerPaymentResponse>>(sellerPaymentService.getSellerPaymentByTotalPrice(totalPrice), HttpStatus.OK);
    }
    
    @PatchMapping("/collectSellerPayment/{sellerPaymentId}")
    public ResponseEntity<SellerPaymentResponse> collectSellerPayment(@PathVariable int sellerPaymentId) 
    {
        return new ResponseEntity<SellerPaymentResponse>(sellerPaymentService.collectSellerPayment(sellerPaymentId), HttpStatus.OK);
    }
    
    @GetMapping("/getCollectedSellerPayments")
    public ResponseEntity<List<SellerPaymentResponse>> getCollectedSellerPayments() 
    {
        return new ResponseEntity<List<SellerPaymentResponse>>(sellerPaymentService.getCollectedSellerPayments(), HttpStatus.OK);
    }

    @GetMapping("/getUncollectedSellerPayments")
    public ResponseEntity<List<SellerPaymentResponse>> getUncollectedSellerPayments() 
    {
        return new ResponseEntity<List<SellerPaymentResponse>>(sellerPaymentService.getUncollectedSellerPayments(), HttpStatus.OK);
    }
    
}
