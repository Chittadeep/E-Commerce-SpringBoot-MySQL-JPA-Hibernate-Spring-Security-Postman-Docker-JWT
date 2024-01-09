package com.example.ecommerce.repositories.buyer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.buyer.BuyerAddress;

@Repository
public interface BuyerAddressRepository extends CrudRepository<BuyerAddress, Integer> {
    public List<BuyerAddress> getBuyerAddressByCity(String city);
    public List<BuyerAddress> getBuyerAddressByAddress(String address);
    public List<BuyerAddress> getBuyerAddressByState(String state);
    public List<BuyerAddress> getBuyerAddressByPincode(String pincode);
    public List<BuyerAddress> getBuyerAddressByBuyerId(int buyerId);
}
