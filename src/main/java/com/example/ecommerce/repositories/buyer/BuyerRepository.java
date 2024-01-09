package com.example.ecommerce.repositories.buyer;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.entities.buyer.Buyer;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, Integer> {
    public List<Buyer> getBuyerByName(String name);
    public Buyer getBuyerByPhoneNumber(String phoneNumber);
    public Buyer getBuyerByMail(String mail);
    @Query("Select b from Buyer as b where b.valid=true")
    public List<Buyer> getAllValidBuyers();
}
