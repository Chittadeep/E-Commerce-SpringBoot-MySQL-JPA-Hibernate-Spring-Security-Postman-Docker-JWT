package com.example.ecommerce.services.product;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.entities.product.ProductImage;
import com.example.ecommerce.repositories.product.ProductImageRepository;

@Service
public class ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;

    public List<ProductImage> getAllProductImages()
    {
        return (List<ProductImage>) productImageRepository.findAll();
    }

    public ProductImage createProductImage(MultipartFile file, int productId)
    {
        ProductImage productImage = new ProductImage();
        try{
            productImage.setImage(file.getBytes());
            productImage.setProductId(productId);
            return productImageRepository.save(productImage);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ProductImage updateProductImage(MultipartFile file, int productImageId)
    {
        ProductImage productImage = getProductImageById(productImageId);
        try{
            productImage.setImage(file.getBytes());
            return productImageRepository.save(productImage);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ProductImage getProductImageById(int productImageId)
    {
        return productImageRepository.findById(productImageId).orElseThrow(()->new RuntimeException("No productImage exists with the given id"));
    }

    public List<ProductImage> getProductImageByProductId(int productId)
    {
        return productImageRepository.getProductImageByProductId(productId);
    }

    public InputStreamResource getProductImageImageById(int productImageId)
    {
        ProductImage productImage = getProductImageById(productImageId);
        byte[] bytes = productImage.getImage();
        if(bytes==null) throw new RuntimeException("The image you requested does not exist");
        InputStream stream = new ByteArrayInputStream(bytes);
        InputStreamResource resource = new InputStreamResource(stream);
        return resource;
    }

}
