package com.codemagen.product.dao.Impl;

import com.codemagen.product.dao.ProductDao;
import com.codemagen.product.dto.ProductDto;
import com.codemagen.product.mapper.ProductResponseMapper;
import com.codemagen.product.model.ProductDetails;
import com.codemagen.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductResponseMapper productResponseMapper;

    @Override
    public ProductDetails saveProduct(ProductDetails product) {
        return repository.save(product);
    }

    @Override
    public ProductDetails updateProduct(ProductDetails product) {
        return repository.save(product); // updates by ID automatically if exists
    }



    @Override
    public  List<ProductDetails> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public ProductDetails getProductById(UUID id) {
        Optional<ProductDetails> optionalProduct = repository.findById(id);
        return optionalProduct.orElse(null); // or throw a custom exception if preferred
    }


    @Override
    public ProductDetails deleteProduct(UUID id) {
        Optional<ProductDetails> product = repository.findById(id);
        if (product.isPresent()) {
            repository.delete(product.get());
            return product.get(); // Return the deleted product
        } else {
            throw new RuntimeException("Product not found with ID: " + id); // You can use a custom exception for better error handling
        }


    }




}