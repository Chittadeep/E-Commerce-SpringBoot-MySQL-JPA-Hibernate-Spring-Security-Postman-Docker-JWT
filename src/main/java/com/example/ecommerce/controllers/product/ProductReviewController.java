package com.example.ecommerce.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.ecommerce.entities.product.ProductReview;
import com.example.ecommerce.services.product.ProductReviewService;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.BooleanArraySerializer;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class ProductReviewController {
    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping("/allProductReviews")
    public ResponseEntity<List<ProductReview>> getAllProductReviews() 
    {
        return new ResponseEntity<List<ProductReview>>(productReviewService.getAllProductReview(), HttpStatus.OK);
    }

    @PostMapping("/createProductReview")
    public ResponseEntity<ProductReview> createProductReview(@RequestBody ProductReview productReview) {
        return new ResponseEntity<ProductReview>(productReviewService.createProductReview(productReview), HttpStatus.CREATED);
    }
    
    @PutMapping("/updateProductReview")
    public ResponseEntity<ProductReview> updateProductReview(@RequestBody ProductReview productReview) {
        return new ResponseEntity<ProductReview>(productReviewService.updateProductReview(productReview), HttpStatus.OK);
    }
    
    @DeleteMapping("/deletProductReview/{productReviewId}")
    public ResponseEntity<Boolean> deleteProductReview(@PathVariable int productReviewId)
    {
        return new ResponseEntity<Boolean>(productReviewService.deleteProductReview(productReviewId), HttpStatus.OK);
    } 

    @GetMapping("/getProductReviewById/{productReviewId}")
    public ResponseEntity<ProductReview> getProductReviewById(@PathVariable int productReviewId) {
        return new ResponseEntity<ProductReview>(productReviewService.getProductReviewById(productReviewId), HttpStatus.OK);
    }
    
    @GetMapping("/getProductReviewByStars/{stars}")
    public ResponseEntity<List<ProductReview>> getProductReviewByStars(@PathVariable int stars) {
        return new ResponseEntity<List<ProductReview>>(productReviewService.getProductReviewByStars(stars), HttpStatus.OK);
    }

    @GetMapping("/getProductReviewByBuyerId/{buyerId}")
    public ResponseEntity<List<ProductReview>> getProductReviewByBuyerId(@PathVariable int buyerId) {
        return new ResponseEntity<List<ProductReview>>(productReviewService.getProductReviewByBuyerId(buyerId), HttpStatus.OK);
    }

    @GetMapping("/getProductReviewByOrderId/{orderId}")
    public ResponseEntity<List<ProductReview>> getProductReviewByOrderId(@PathVariable int orderId) 
    {
        return new ResponseEntity<List<ProductReview>>(productReviewService.getProductReviewByOrderId(orderId), HttpStatus.OK);
    }
    
    @GetMapping("/getProductReviewByProductId/{productId}")
    public ResponseEntity<List<ProductReview>> getProductReviewByProductId(int productId) 
    {
        return new ResponseEntity<List<ProductReview>>(productReviewService.getProductReviewByProductId(productId), HttpStatus.OK);
    }
    
}
