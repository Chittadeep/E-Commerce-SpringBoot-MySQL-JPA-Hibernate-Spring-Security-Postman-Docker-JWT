package com.example.ecommerce.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.ecommerce.entities.product.ProductReview;
import com.example.ecommerce.models.product.ProductReviewResponse;
import com.example.ecommerce.services.product.ProductReviewService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class ProductReviewController {
    @Autowired
    private ProductReviewService productReviewService;

    @GetMapping("/allProductReviews")
    public ResponseEntity<List<ProductReviewResponse>> getAllProductReviews() 
    {
        return new ResponseEntity<List<ProductReviewResponse>>(productReviewService.getAllProductReview(), HttpStatus.OK);
    }

    @PostMapping("/createProductReview")
    public ResponseEntity<ProductReviewResponse> createProductReview(@RequestBody ProductReview productReview) {
        return new ResponseEntity<ProductReviewResponse>(productReviewService.createProductReview(productReview), HttpStatus.CREATED);
    }
    
    @PutMapping("/updateProductReview")
    public ResponseEntity<ProductReviewResponse> updateProductReview(@RequestBody ProductReview productReview) {
        return new ResponseEntity<ProductReviewResponse>(productReviewService.updateProductReview(productReview), HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteProductReview/{productReviewId}")
    public ResponseEntity<Boolean> deleteProductReview(@PathVariable int productReviewId)
    {
        return new ResponseEntity<Boolean>(productReviewService.deleteProductReview(productReviewId), HttpStatus.OK);
    } 

    @GetMapping("/getProductReviewById/{productReviewId}")
    public ResponseEntity<ProductReviewResponse> getProductReviewById(@PathVariable int productReviewId) {
        return new ResponseEntity<ProductReviewResponse>(productReviewService.getProductReviewResponseById(productReviewId), HttpStatus.OK);
    }
    
    @GetMapping("/getProductReviewByStars/{stars}")
    public ResponseEntity<List<ProductReviewResponse>> getProductReviewByStars(@PathVariable int stars) {
        return new ResponseEntity<List<ProductReviewResponse>>(productReviewService.getProductReviewByStars(stars), HttpStatus.OK);
    }

    @GetMapping("/getProductReviewByBuyerId/{buyerId}")
    public ResponseEntity<List<ProductReviewResponse>> getProductReviewByBuyerId(@PathVariable int buyerId) {
        return new ResponseEntity<List<ProductReviewResponse>>(productReviewService.getProductReviewByBuyerId(buyerId), HttpStatus.OK);
    }

    @GetMapping("/getProductReviewByOrderItemId/{orderItemId}")
    public ResponseEntity<List<ProductReviewResponse>> getProductReviewByOrderItemId(@PathVariable int orderItemId) 
    {
        return new ResponseEntity<List<ProductReviewResponse>>(productReviewService.getProductReviewByOrderItemId(orderItemId), HttpStatus.OK);
    }
    
    @GetMapping("/getProductReviewByProductId/{productId}")
    public ResponseEntity<List<ProductReviewResponse>> getProductReviewByProductId(int productId) 
    {
        return new ResponseEntity<List<ProductReviewResponse>>(productReviewService.getProductReviewByProductId(productId), HttpStatus.OK);
    }
    
}
