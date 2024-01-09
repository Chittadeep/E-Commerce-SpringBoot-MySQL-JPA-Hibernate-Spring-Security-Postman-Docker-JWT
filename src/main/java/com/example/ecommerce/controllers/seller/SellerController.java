package com.example.ecommerce.controllers.seller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.ecommerce.entities.seller.Seller;
import com.example.ecommerce.models.seller.SellerRequest;
import com.example.ecommerce.services.seller.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class SellerController { 

    @Autowired
    private SellerService sellerService;

    @GetMapping(path="/allSellers")
    public ResponseEntity<List<Seller>> getAllSellers() {
        return new ResponseEntity<List<Seller>>(sellerService.getAllSellers(), HttpStatus.OK);
    }

    @GetMapping("/getSellerById/{sellerId}")
    public ResponseEntity<Seller> getSellerById(@PathVariable int sellerId) {
        return new ResponseEntity<Seller>(sellerService.getSellerById(sellerId), HttpStatus.OK);
    }

    @GetMapping("/getSellerByName/{name}")
    public ResponseEntity<List<Seller>> getSellerByName(@PathVariable String name) {
        return new ResponseEntity<List<Seller>>(sellerService.getSellerByName(name), HttpStatus.OK);
    }

    @GetMapping("/getSellerByMail/{sellerMail}")
    public ResponseEntity<Seller> getSellerByMail(@PathVariable String sellerMail) {
        return new ResponseEntity<Seller>(sellerService.getSellerByMail(sellerMail), HttpStatus.OK);
    }

    @GetMapping("/getSellerByPhoneNumber/{phoneNumber}")
    public ResponseEntity<Seller> getSellerByPhoneNumber(@PathVariable String phoneNumber) {
        return new ResponseEntity<Seller>(sellerService.getSellerByPhoneNumber(phoneNumber), HttpStatus.OK);
    }
    
    @PostMapping("/createSeller")
    public ResponseEntity<Seller> createSeller(@RequestBody SellerRequest sellerRequest) {
         return new ResponseEntity<Seller>(sellerService.createSeller(sellerRequest), HttpStatus.CREATED);
    }

    @PutMapping("/updateSeller")
    public ResponseEntity<Seller> updateSeller(@RequestBody Seller seller) {
        return new ResponseEntity<Seller>(sellerService.updateSeller(seller), HttpStatus.ACCEPTED);
    }
      
    @GetMapping("/getAllValidSellers")
    public ResponseEntity<List<Seller>> getAllValidSellers() {
        return new ResponseEntity<List<Seller>>(sellerService.getAllValidSellers(), HttpStatus.OK);
    }
    
}