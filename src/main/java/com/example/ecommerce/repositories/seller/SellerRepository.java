package com.example.ecommerce.repositories.seller;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.buyer.Buyer;
import com.example.ecommerce.entities.seller.Seller;

@Repository
public interface SellerRepository extends CrudRepository<Seller,Integer> {
    public Seller getSellerByMail(String mail);

    public Seller getSellerByPhoneNumber(String phoneNumber);

    public List<Seller> getSellerByName(String name);

    @Query("Select s from Seller as s where s.valid=true")
    public List<Seller> getAllValidSellers();
}
