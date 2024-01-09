package com.example.ecommerce.services.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;

import com.example.ecommerce.entities.globals.LoginDetails;
import com.example.ecommerce.entities.seller.Seller;
import com.example.ecommerce.models.seller.SellerRequest;
import com.example.ecommerce.repositories.globals.LoginDetailsRepository;
import com.example.ecommerce.repositories.seller.SellerRepository;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private LoginDetailsRepository loginDetailsRepository;

    public Seller createSeller(SellerRequest sellerRequest)
    {
        loginDetailsRepository.save(new LoginDetails(sellerRequest));
        return sellerRepository.save(new Seller(sellerRequest));
    }

    public Seller updateSeller(Seller seller)
    {
        Seller oldSeller = getSellerById(seller.getId());
        oldSeller.setName(seller.getName());
        oldSeller.setPhoneNumber(seller.getPhoneNumber());
        return sellerRepository.save(oldSeller);
    }

    public List<Seller> getAllSellers()
    {
        return (List<Seller>) sellerRepository.findAll();
    }

    public Seller getSellerById(int sellerId)
    {
        return sellerRepository.findById(sellerId).orElseThrow(()->new RuntimeException("No seller with this Id exists"));
    }

    public List<Seller> getSellerByName(String name) {
        return sellerRepository.getSellerByName(name);
    }

    public Seller getSellerByMail(String mail)
    {
        return sellerRepository.getSellerByMail(mail);
    }

    public Seller getSellerByPhoneNumber(String phoneNumber)
    {
        return sellerRepository.getSellerByPhoneNumber(phoneNumber);
    }

    public List<Seller> getAllValidSellers()
    {
        return sellerRepository.getAllValidSellers();
    }

    public boolean updateProfilePicture(int sellerId, MultipartFile file)
    {
        Seller seller = getSellerById(sellerId);
        try{
        seller.setImage(file.getBytes());
        sellerRepository.save(seller);
        return true;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public InputStreamResource getProfilePicture(int sellerId)
    {
        Seller seller = getSellerById(sellerId);
        byte[] bytes = seller.getImage();
        if(bytes==null) throw new RuntimeException("The image you requested does not exist");
        InputStream stream = new ByteArrayInputStream(bytes);
        InputStreamResource resource = new InputStreamResource(stream);
        return resource;
    }

}
