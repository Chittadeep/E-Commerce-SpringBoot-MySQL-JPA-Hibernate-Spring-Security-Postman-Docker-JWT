package com.example.ecommerce.services.seller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.seller.Seller;
import com.example.ecommerce.entities.seller.SellerAddress;
import com.example.ecommerce.repositories.seller.SellerAddressRepository;
import com.example.ecommerce.repositories.seller.SellerRepository;

@Service
public class SellerAddressService {
    @Autowired
    private SellerAddressRepository sellerAddressRepository;
    @Autowired
    private SellerRepository sellerRepository;

    public List<SellerAddress> getAllSellerAddresses()
    {
        return (List<SellerAddress>) sellerAddressRepository.findAll();
    }

    public SellerAddress createSellerAddress(SellerAddress sellerAddress)
    {
        return sellerAddressRepository.save(sellerAddress);
    }

    public SellerAddress updateSellerAddress(SellerAddress sellerAddress)
    {
        getSellerAddressById(sellerAddress.getId());
        return sellerAddressRepository.save(sellerAddress);
    }

    public SellerAddress getSellerAddressById(int id)
    {
        return sellerAddressRepository.findById(id).orElseThrow(()->new RuntimeException("No seller-address with this id exists"));
    }

    public List<SellerAddress> getSellerAddressBySellerId(int sellerId)
    {   sellerRepository.findById(sellerId).orElseThrow(()-> new RuntimeException("any seller with this id does not exist"));
        return sellerAddressRepository.getSellerAddressBySellerId(sellerId);
    }

    public List<SellerAddress> getSellerAddressByAddress(String address)
    {
        return sellerAddressRepository.getSellerAddressByAddress(address);
    }

    public List<SellerAddress> getSellerAddressByCity(String city)
    {
        return sellerAddressRepository.getSellerAddressByCity(city);
    }
    public List<SellerAddress> getSellerAddressByState(String state)
    {
        return sellerAddressRepository.getSellerAddressByState(state);
    }
    public List<SellerAddress> getSellerAddressByPincode(String pincode)
    {
        return sellerAddressRepository.getSellerAddressByPincode(pincode);
    }

    public boolean deleteSellerAddress(int sellerAddressId)
    {
        getSellerAddressById(sellerAddressId);
        sellerAddressRepository.deleteById(sellerAddressId);
        return true;
    }
}
