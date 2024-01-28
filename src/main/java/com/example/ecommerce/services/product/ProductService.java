package com.example.ecommerce.services.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.entities.product.Category;
import com.example.ecommerce.entities.product.Product;
import com.example.ecommerce.entities.seller.Seller;
import com.example.ecommerce.entities.seller.SellerAddress;
import com.example.ecommerce.models.product.ProductResponse;
import com.example.ecommerce.repositories.product.CategoryRepository;
import com.example.ecommerce.repositories.product.ProductRepository;
import com.example.ecommerce.repositories.seller.SellerAddressRepository;
import com.example.ecommerce.repositories.seller.SellerRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SellerAddressRepository sellerAddressRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public ProductResponse createProduct(Product product)
    {
        if(sellerAddressRepository.findById(product.getSellerAddress().getId()).get().getSellerId()!=product.getSeller().getId())
         throw new RuntimeException("Product cannot be created because the seller address does not belong to the seller");
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

    public ProductResponse getProductResponseById(int id)
    {
        return new ProductResponse(getProductById(id));
    }

    private Product getProductById(int id)
    {
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException("Any product with the given id does not exist"));
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

    public List<ProductResponse> createMenusFromCSV(MultipartFile multipartFile) throws IOException
    {
        byte[] bytes = multipartFile.getBytes();
        File file = new File(UUID.randomUUID().toString());
        FileOutputStream stream = new FileOutputStream(file.getPath());
        stream.write(bytes);
        FileReader fileReader = new FileReader(file.getPath());
        List<Product> products = new ArrayList<Product>();
        try(CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();)
        {
            String []row;
            String name;
            double price;
            int quantity, categoryId, sellerId, sellerAddressId;
            while((row = csvReader.readNext())!=null)
            {
                name = row[0];
                price = Double.parseDouble(row[1]);
                quantity = Integer.parseInt(row[2]);
                categoryId = Integer.parseInt(row[3]);
                sellerId = Integer.parseInt(row[5]);
                sellerAddressId = Integer.parseInt(row[6]);
                Product product = new Product();
                product.setName(name);
                product.setPrice(price);
                product.setQuantity(quantity);
                List<Category> categories= new ArrayList<Category>();
                categories.add(categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Product cannot be created with category id which does not exists ")));
                product.setCategory(categories);
                SellerAddress sellerAddress = sellerAddressRepository.findById(sellerAddressId).orElseThrow(()->new RuntimeException("Product cannot be created with wrong seller address Id which does not exist"));
                Seller seller = sellerRepository.findById(sellerId).orElseThrow(()->new RuntimeException("Product cannot be created because seller with this ide does not exist"));
                if(seller.getId()!=sellerAddress.getSellerId()) 
                    throw new RuntimeException("Product cannot be created because the seller address does not belong to the seller");
                product.setSeller(seller);
                product.setSellerAddress(sellerAddress);
                products.add(product);
            }
            productRepository.saveAll(products);
        }
        return products.stream().map(ProductResponse::new).toList();
    }

    public boolean validateUnvalidateProduct(int productId, boolean validation)
    {
        Product product =getProductById(productId);
        product.setAvailable(validation);
        productRepository.save(product);
        return true;
    }

    public List<ProductResponse> getProductsByCategoryId(int categoryId)
    {
        return productRepository.getProductByCategoryId(categoryId).stream().map(ProductResponse::new).toList();
    }

    public List<ProductResponse> getAvailableProducts()
    {
        return productRepository.getAvailableProducts().stream().map(ProductResponse::new).toList();
    }
}
