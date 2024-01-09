package com.example.ecommerce.services.buyer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.buyer.BuyerAddress;
import com.example.ecommerce.repositories.buyer.BuyerAddressRepository;

@Service
public class BuyerAddressService {
    @Autowired
    private BuyerAddressRepository buyerAddressRepository;

    public List<BuyerAddress> getAllBuyerAddress()
    {
        return (List<BuyerAddress>) buyerAddressRepository.findAll();
    }

    public BuyerAddress createBuyerAddress(BuyerAddress buyerAddress)
    {
        return buyerAddressRepository.save(buyerAddress);
    }

    public BuyerAddress updateBuyerAddress(BuyerAddress buyerAddress)
    {
        getBuyerAddressById(buyerAddress.getId());
        return buyerAddressRepository.save(buyerAddress);
    }

    public BuyerAddress getBuyerAddressById(int buyerAddressId)
    {
        return buyerAddressRepository.findById(buyerAddressId).orElseThrow(()->new RuntimeException("No buyer Address exists with this Id"));
    }

    public List<BuyerAddress> getBuyerAddressByBuyerId(int buyerId)
    {
        return buyerAddressRepository.getBuyerAddressByBuyerId(buyerId);
    }

    public List<BuyerAddress> getBuyerAddressByCity(String city)
    {
        return buyerAddressRepository.getBuyerAddressByCity(city);
    }

    public List<BuyerAddress> getBuyerAddressByState(String state)
    {
        return buyerAddressRepository.getBuyerAddressByState(state);
    }

    public List<BuyerAddress> getBuyerAddressByAddress(String address)
    {
        return buyerAddressRepository.getBuyerAddressByAddress(address);
    }

    public List<BuyerAddress> getBuyerAddressByPincode(String pincode)
    {
        return buyerAddressRepository.getBuyerAddressByPincode(pincode);
    }

    public boolean deleteBuyerAddress(int buyerAddressId)
    {
        getBuyerAddressById(buyerAddressId);
        buyerAddressRepository.deleteById(buyerAddressId);
        return true;
    }
}
