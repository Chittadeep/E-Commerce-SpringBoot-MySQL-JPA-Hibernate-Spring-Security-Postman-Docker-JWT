package com.example.ecommerce.repositories.seller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.seller.SellerAddress;

@Repository
public interface SellerAddressRepository extends CrudRepository<SellerAddress, Integer> {
    public List<SellerAddress> getSellerAddressBySellerId(int sellerId);

    public List<SellerAddress> getSellerAddressByAddress(String address);

    public List<SellerAddress> getSellerAddressByCity(String city);

    public List<SellerAddress> getSellerAddressByPincode(String pincode);

    public List<SellerAddress> getSellerAddressByState(String state);
}
