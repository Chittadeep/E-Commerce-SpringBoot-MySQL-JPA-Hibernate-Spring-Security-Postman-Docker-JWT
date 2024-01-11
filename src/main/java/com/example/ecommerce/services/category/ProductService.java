package com.example.ecommerce.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.ecommerce.entities.product.Product;
import com.example.ecommerce.models.product.ProductResponse;
import com.example.ecommerce.repositories.product.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductResponse createProduct(Product product)
    {
        productRepository.save(product);
        
        System.out.println(product.getSeller().getMail());
        System.out.println(product.getSellerAddress().getCity());
        return new ProductResponse(product);
    }

    public Product updateProduct(Product product)
    {
        getProductById(product.getId());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts()
    {
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(int id)
    {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Any product with the given id does not exist"));
    }

    public List<Product> getProductByName(String name)
    {
        return productRepository.getProductByName(name);
    }

    public List<Product> getProductByPrice(double price)
    {
        return productRepository.getProductByPrice(price);
    }

    public List<Product> getProductByQuantity(int quantity)
    {
        return productRepository.getProductByQuantity(quantity);
    }

    public List<Product> getProductBySeller_Id(int sellerId)
    {
        return productRepository.getProductBySeller_Id(sellerId);
    }
}
