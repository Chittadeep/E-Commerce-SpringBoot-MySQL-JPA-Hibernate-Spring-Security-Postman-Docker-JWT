package com.example.ecommerce.controllers.buyer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.models.buyer.BuyerRequest;
import com.example.ecommerce.services.buyer.BuyerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @GetMapping("/allBuyers")
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        return new ResponseEntity<List<Buyer>>(buyerService.getAllBuyers(), HttpStatus.OK);
    }

    @GetMapping("/getBuyerById/{buyerId}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable int buyerId) {
        return new ResponseEntity<Buyer>(buyerService.getBuyerById(buyerId), HttpStatus.OK);
    }

    @PostMapping("/createBuyer")
    public ResponseEntity<Buyer> createBuyer(@RequestBody BuyerRequest buyerRequest)
    {
        return new ResponseEntity<Buyer>(buyerService.createBuyer(buyerRequest), HttpStatus.CREATED);
    }
    
    @PutMapping("/updateBuyer")
    public ResponseEntity<Buyer> updateBuyer(@RequestBody Buyer buyer) {
        return new ResponseEntity<Buyer>(buyerService.updateBuyer(buyer), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getBuyerByName/{name}")
    public ResponseEntity<List<Buyer>> getBuyerByName(@PathVariable String name) {
        return new ResponseEntity<List<Buyer>>(buyerService.getBuyerByName(name), HttpStatus.OK);
    }

    @GetMapping("/getBuyerByPhoneNumber/{phoneNumber}")
    public ResponseEntity<Buyer> getBuyerByPhoneNumber(@PathVariable String phoneNumber) {
        return new ResponseEntity<Buyer>(buyerService.getBuyerByPhoneNumber(phoneNumber), HttpStatus.OK);
    }
    
    @GetMapping("/getBuyerByMail/{mail}")
    public ResponseEntity<Buyer> getBuyerByMail(@PathVariable String mail) {
        return new ResponseEntity<Buyer>(buyerService.getBuyerByMail(mail), HttpStatus.OK);
    }
    
    @GetMapping("/getAllValidBuyers")
    public ResponseEntity<List<Buyer>> getAllValidBuyers() {
        return new ResponseEntity<List<Buyer>>(buyerService.getAllValidBuyers(), HttpStatus.OK);
    }
    
}
