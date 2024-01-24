package com.example.ecommerce.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.ecommerce.entities.product.Product;
import com.example.ecommerce.models.product.ProductResponse;
import com.example.ecommerce.repositories.product.ProductRepository;
import com.example.ecommerce.repositories.seller.SellerAddressRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SellerAddressRepository sellerAddressRepository;


    public ProductResponse createProduct(Product product)
    {
        if(sellerAddressRepository.findById(product.getSellerAddress().getId()).get().getSellerId()!=product.getSeller().getId()) throw new RuntimeException("Product cannot be created because the seller address does not belong to the seller");
        productRepository.save(product);
        return new ProductResponse(product);
    }

    public ProductResponse updateProduct(Product product)
    {
        getProductById(product.getId());
        return new ProductResponse(productRepository.save(product));
    }

    public List<ProductResponse> getAllProducts()
    {
        return ((List<Product>) productRepository.findAll()).stream().map(ProductResponse::new).toList();
    }

    public ProductResponse getProductById(int id)
    {
        return new ProductResponse(productRepository.findById(id).orElseThrow(()-> new RuntimeException("Any product with the given id does not exist")));
    }

    public List<ProductResponse> getProductByName(String name)
    {
        return productRepository.getProductByName(name).stream().map(ProductResponse::new).toList();
    }

    public List<ProductResponse> getProductByPrice(double price)
    {
        return productRepository.getProductByPrice(price).stream().map(ProductResponse::new).toList();
    }

    public List<ProductResponse> getProductByQuantity(int quantity)
    {
        return productRepository.getProductByQuantity(quantity).stream().map(ProductResponse::new).toList();
    }

    public List<ProductResponse> getProductBySeller_Id(int sellerId)
    {
        return productRepository.getProductBySeller_Id(sellerId).stream().map(ProductResponse::new).toList();
    }

}
