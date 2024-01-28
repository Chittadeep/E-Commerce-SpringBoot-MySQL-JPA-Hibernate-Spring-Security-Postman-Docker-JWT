package com.example.ecommerce.repositories.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.ecommerce.entities.product.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    
    public List<Product> getProductByName(String name);

    public List<Product> getProductByPrice(double price);

    public List<Product> getProductByQuantity(int quantity);

    @Query("Select p from Product as p where p.available=true")
    public List<Product> getAvailableProducts();

    public List<Product> getProductBySeller_Id(int sellerId);

    public List<Product> getProductByCategoryId(int categoryId);
}
