package com.example.ecommerce.controllers.seller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient.ResponseSpec;

import com.example.ecommerce.entities.seller.Seller;
import com.example.ecommerce.entities.seller.SellerAddress;
import com.example.ecommerce.services.seller.SellerAddressService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class SellerAddressController {
    @Autowired
    private SellerAddressService sellerAddressService;

    @GetMapping("/allSellerAddresses")
    public ResponseEntity<List<SellerAddress>> getAllSellerAddresses() {
        return new ResponseEntity<List<SellerAddress>>(sellerAddressService.getAllSellerAddresses(), HttpStatus.OK);
    }

    @GetMapping("/getSellerAddressById/{sellerAddressId}")
    public ResponseEntity<SellerAddress> getSellerAddressById(@PathVariable int sellerAddressId) {
        return new ResponseEntity<SellerAddress>(sellerAddressService.getSellerAddressById(sellerAddressId), HttpStatus.OK);
    }
    
    @GetMapping("/getSellerAddressBySellerId/{sellerId}")
    public ResponseEntity<List<SellerAddress>> getSellerAddressBySellerId(@PathVariable int sellerId) 
    {
        return new ResponseEntity<List<SellerAddress>>(sellerAddressService.getSellerAddressBySellerId(sellerId), HttpStatus.OK);
    }

    @GetMapping("/getSellerAddressByAddress/{address}")
    public ResponseEntity<List<SellerAddress>> geSellerAddressByAddress(@PathVariable String address) 
    {
        return new ResponseEntity<List<SellerAddress>>(sellerAddressService.getSellerAddressByAddress(address), HttpStatus.OK);
    }
    
    @GetMapping("/getSellerAddressByCity/{city}")
    public ResponseEntity<List<SellerAddress>> getSellerAddressByCity(@PathVariable String city) 
    {
        return new ResponseEntity<List<SellerAddress>>(sellerAddressService.getSellerAddressByCity(city), HttpStatus.OK);
    }
    
    @GetMapping("/getSellerAddressByState/{state}")
    public ResponseEntity<List<SellerAddress>> getSellerAddressByState(@PathVariable String state) {
        return new ResponseEntity<List<SellerAddress>>(sellerAddressService.getSellerAddressByState(state), HttpStatus.OK);
    }

    @GetMapping("/getSellerAddressByPincode/{pincode}")
    public ResponseEntity<List<SellerAddress>> getSellerAddressByPincode(@PathVariable String pincode) 
    {
        return new ResponseEntity<List<SellerAddress>>(sellerAddressService.getSellerAddressByPincode(pincode), HttpStatus.OK);
    }
    
    @PostMapping("/createSellerAddress")
    public ResponseEntity<SellerAddress> creatSellerAddress(@RequestBody SellerAddress sellerAddress) 
    {
        return new ResponseEntity<SellerAddress>(sellerAddressService.createSellerAddress(sellerAddress), HttpStatus.CREATED); 
    }

    @PutMapping("/updateSellerAddress")
    public ResponseEntity<SellerAddress> updateSellerAddress(@RequestBody SellerAddress sellerAddress) {
        return new ResponseEntity<SellerAddress>(sellerAddressService.updateSellerAddress(sellerAddress), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteSellerAddress/{sellerAddressId}")
    public ResponseEntity<Boolean> deleteSellerAddress(@PathVariable int sellerAddressId)
    {
        return new ResponseEntity<Boolean>(sellerAddressService.deleteSellerAddress(sellerAddressId), HttpStatus.OK);
    }

}
