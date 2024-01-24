package com.example.ecommerce.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.entities.product.Product;
import com.example.ecommerce.models.product.ProductResponse;
import com.example.ecommerce.services.product.ProductService;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return new ResponseEntity<List<ProductResponse>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody Product product) {
        return new ResponseEntity<ProductResponse>(productService.createProduct(product), HttpStatus.CREATED);
    }
    
    @PutMapping("/updateProduct")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody Product product) {
       return new ResponseEntity<ProductResponse>(productService.updateProduct(product), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int productId) {
        return new ResponseEntity<ProductResponse>(productService.getProductById(productId), HttpStatus.OK);
    }

    @GetMapping("/getProductByName/{productName}")
    public ResponseEntity<List<ProductResponse>> getProductByName(@PathVariable String productName) {
        return new ResponseEntity<List<ProductResponse>>(productService.getProductByName(productName), HttpStatus.OK);
    }

    @GetMapping("/getProductByPrice/{price}")
    public ResponseEntity<List<ProductResponse>> getProductByPrice(@PathVariable double price) 
    {
        return new ResponseEntity<List<ProductResponse>>(productService.getProductByPrice(price), HttpStatus.OK);
    }
    
    @GetMapping("/getProductByQuantity/{quantity}")
    public ResponseEntity<List<ProductResponse>> getProductByQuantity(@PathVariable int quantity)
    {
        return new ResponseEntity<List<ProductResponse>>(productService.getProductByQuantity(quantity), HttpStatus.OK);
    }

    @GetMapping("/getProductBySellerId/{sellerId}")
    public ResponseEntity<List<ProductResponse>> getProductBySeller_SellerId(@PathVariable int sellerId) {
        return new ResponseEntity<List<ProductResponse>>(productService.getProductBySeller_Id(sellerId), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> addProductsViaCSV(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<List<ProductResponse>>(productService.createMenusFromCSV(file), HttpStatus.ACCEPTED);
    }
    
    
}