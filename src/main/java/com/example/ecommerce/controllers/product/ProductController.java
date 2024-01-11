package com.example.ecommerce.controllers.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entities.product.Product;
import com.example.ecommerce.models.product.ProductResponse;
import com.example.ecommerce.services.category.ProductService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody Product product) {
        return new ResponseEntity<ProductResponse>(productService.createProduct(product), HttpStatus.CREATED);
    }
    
    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
       return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
    }

    @GetMapping("/getProductByName/{productName}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String productName) {
        return new ResponseEntity<List<Product>>(productService.getProductByName(productName), HttpStatus.OK);
    }

    @GetMapping("/getProductByPrice/{price}")
    public ResponseEntity<List<Product>> getProductByPrice(@PathVariable double price) 
    {
        return new ResponseEntity<List<Product>>(productService.getProductByPrice(price), HttpStatus.OK);
    }
    
    @GetMapping("/getProductByQuantity/{quantity}")
    public ResponseEntity<List<Product>> getProductByQuantity(@PathVariable int quantity)
    {
        return new ResponseEntity<List<Product>>(productService.getProductByQuantity(quantity), HttpStatus.OK);
    }

    @GetMapping("/getProductBySellerId/{sellerId}")
    public ResponseEntity<List<Product>> getProductBySeller_SellerId(@PathVariable int sellerId) {
        return new ResponseEntity<List<Product>>(productService.getProductBySeller_Id(sellerId), HttpStatus.OK);
    }
    
}
