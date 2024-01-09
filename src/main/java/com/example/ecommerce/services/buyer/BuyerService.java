package com.example.ecommerce.services.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.globals.LoginDetails;
import com.example.ecommerce.models.buyer.BuyerRequest;
import com.example.ecommerce.repositories.buyer.BuyerRepository;
import com.example.ecommerce.repositories.globals.LoginDetailsRepository;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;
    @Autowired
    private LoginDetailsRepository loginDetailsRepository;

    public List<Buyer> getAllBuyers()
    {
        return (List<Buyer>) buyerRepository.findAll();
    }

    public Buyer createBuyer(BuyerRequest buyerRequest)
    {
        LoginDetails loginDetails = new LoginDetails(buyerRequest);
        loginDetailsRepository.save(loginDetails);
        return buyerRepository.save(new Buyer(buyerRequest));
    } 
    
    public Buyer updateBuyer(Buyer buyer)
    {
        Buyer oldBuyer = getBuyerById(buyer.getId());
        oldBuyer.setName(buyer.getName());
        oldBuyer.setPhoneNumber(buyer.getPhoneNumber());
        return buyerRepository.save(oldBuyer);
    }

    public Buyer getBuyerById(int id)
    {
        return buyerRepository.findById(id).orElseThrow(()-> new RuntimeException("No buyer with the given Id exists"));
    }
    
    public List<Buyer> getBuyerByName(String name)
    {
        return buyerRepository.getBuyerByName(name);
    }

    public Buyer getBuyerByPhoneNumber(String phoneNumber)
    {
        return buyerRepository.getBuyerByPhoneNumber(phoneNumber);
    }

    public Buyer getBuyerByMail(String mail)
    {
        return buyerRepository.getBuyerByMail(mail);
    } 

    public List<Buyer> getAllValidBuyers()
    {
        return buyerRepository.getAllValidBuyers();
    }
}
