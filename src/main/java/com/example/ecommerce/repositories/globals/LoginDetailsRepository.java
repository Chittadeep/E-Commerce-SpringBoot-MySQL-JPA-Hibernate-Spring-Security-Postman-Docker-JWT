package com.example.ecommerce.repositories.globals;

import org.springframework.data.repository.CrudRepository;

import com.example.ecommerce.entities.globals.LoginDetails;

public interface LoginDetailsRepository extends CrudRepository<LoginDetails, Integer> {
    
}
