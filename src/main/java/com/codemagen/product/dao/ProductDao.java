package com.codemagen.product.dao;

import com.codemagen.product.dto.ProductDto;
import com.codemagen.product.model.ProductDetails;
import java.util.List;
import java.util.UUID;


public interface ProductDao {
    ProductDetails saveProduct(ProductDetails product);
    List<ProductDetails> getAllProducts();
    ProductDetails getProductById(UUID id);
    ProductDetails deleteProduct(UUID id);
    ProductDetails updateProduct(ProductDetails product);








}
