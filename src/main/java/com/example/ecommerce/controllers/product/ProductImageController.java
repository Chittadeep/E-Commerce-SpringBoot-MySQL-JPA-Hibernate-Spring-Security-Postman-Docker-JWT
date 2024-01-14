package com.example.ecommerce.controllers.product;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.entities.product.ProductImage;
import com.example.ecommerce.services.product.ProductImageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @GetMapping("/allProductImages")
    public ResponseEntity<List<ProductImage>> getAllProductImages() {
        return new ResponseEntity<List<ProductImage>>(productImageService.getAllProductImages(), HttpStatus.OK);
    }

    @PostMapping("/createProductImage/{productId}")
    public ResponseEntity<ProductImage> createProductImage(@PathVariable int productId, @RequestParam MultipartFile file) 
    {
        return new ResponseEntity<ProductImage>(productImageService.createProductImage(file, productId), HttpStatus.OK);
    }
    
    @PutMapping("/updateProductImage/{productImageId}")
    public ResponseEntity<ProductImage> updateProductImage(@PathVariable int productImageId, @RequestParam MultipartFile file)
    {    
        return new ResponseEntity<ProductImage>(productImageService.updateProductImage(file, productImageId), HttpStatus.OK);
    }

    @GetMapping("/getProductImageById/{productImageId}")
    public ResponseEntity<ProductImage> getProductImageById(@PathVariable int productImageId) 
    {
        return new ResponseEntity<ProductImage>(productImageService.getProductImageById(productImageId), HttpStatus.OK);
    }
    
    @GetMapping("/getProductImageByProductId/{productId}")
    public ResponseEntity<List<ProductImage>> getProductImageByProductId(@PathVariable int productId) 
    {
        return new ResponseEntity<List<ProductImage>>(productImageService.getProductImageByProductId(productId), HttpStatus.OK);
    }

    @GetMapping("/getProductImageImageById/{productImageId}")
    public ResponseEntity<InputStreamResource> getProductImageImageById(@PathVariable int productImageId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = productImage.jpg");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.IMAGE_JPEG).body(productImageService.getProductImageImageById(productImageId));
    }
    
}
