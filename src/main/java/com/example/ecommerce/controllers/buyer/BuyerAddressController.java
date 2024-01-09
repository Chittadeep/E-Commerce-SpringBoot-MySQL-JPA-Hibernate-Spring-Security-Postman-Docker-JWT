package com.example.ecommerce.controllers.buyer;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.buyer.BuyerAddress;
import com.example.ecommerce.services.buyer.BuyerAddressService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class BuyerAddressController {
    @Autowired
    private BuyerAddressService buyerAddressService;

    @GetMapping("/getAllBuyerAddress")
    public ResponseEntity<List<BuyerAddress>> getAllBuyerAddress() {
        return new ResponseEntity<List<BuyerAddress>>(buyerAddressService.getAllBuyerAddress(), HttpStatus.OK);
    }

    @GetMapping("/getBuyerAddressById/{buyerAddressId}")
    public ResponseEntity<BuyerAddress> getBuyerAddressById(@PathVariable int buyerAddressId)
    {
        return new ResponseEntity<BuyerAddress>(buyerAddressService.getBuyerAddressById(buyerAddressId), HttpStatus.OK);
    }

    @PostMapping("/createBuyerAddress")
    public ResponseEntity<BuyerAddress> createBuyerAddress(@RequestBody BuyerAddress buyerAddress) 
    {    
        return new ResponseEntity<BuyerAddress>(buyerAddressService.createBuyerAddress(buyerAddress), HttpStatus.CREATED);
    }
    
    @PutMapping("/updateBuyerAddress")
    public ResponseEntity<BuyerAddress> updateBuyerAddress(@RequestBody BuyerAddress buyerAddress) 
    {
        return new ResponseEntity<BuyerAddress>(buyerAddressService.updateBuyerAddress(buyerAddress), HttpStatus.OK);
    }

    @GetMapping("/getAllBuyerAddressByBuyerId/{buyerId}")
    public ResponseEntity<List<BuyerAddress>> getAllBuyerAddressByBuyerId(@PathVariable int buyerId) {
        return new ResponseEntity<List<BuyerAddress>>(buyerAddressService.getBuyerAddressByBuyerId(buyerId), HttpStatus.OK);
    }

    @GetMapping("/getAllBuyerAddressByCity/{city}")
    public ResponseEntity<List<BuyerAddress>> getAllBuyerAddressByCity(@PathVariable String city) {
        return new ResponseEntity<List<BuyerAddress>>(buyerAddressService.getBuyerAddressByCity(city), HttpStatus.OK);
    }

    @GetMapping("/getAllBuyerAddressByAddress/{address}")
    public ResponseEntity<List<BuyerAddress>> getAllBuyerAddressByAddress(@PathVariable String address) {
        return new ResponseEntity<List<BuyerAddress>>(buyerAddressService.getBuyerAddressByAddress(address), HttpStatus.OK);
    }

    @GetMapping("/getAllBuyerAddressByPincode/{pincode}")
    public ResponseEntity<List<BuyerAddress>> getAllBuyerAddressByPincode(@PathVariable String pincode) {
        return new ResponseEntity<List<BuyerAddress>>(buyerAddressService.getBuyerAddressByPincode(pincode), HttpStatus.OK);
    }

    @GetMapping("/getAllBuyerAddressByState/{state}")
    public ResponseEntity<List<BuyerAddress>> getAllBuyerAddressByState(@PathVariable String state) {
        return new ResponseEntity<List<BuyerAddress>>(buyerAddressService.getBuyerAddressByState(state), HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteBuyerAddress/{buyerAddressId}")
    public ResponseEntity<Boolean> deleteBuyerAddress(@PathVariable int buyerAddressId)
    {
        return new ResponseEntity<Boolean>(buyerAddressService.deleteBuyerAddress(buyerAddressId), HttpStatus.OK);
    }
}
