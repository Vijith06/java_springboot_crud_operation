package com.codemagen.product.service;

import com.codemagen.product.dto.ProductDto;
import com.codemagen.product.dto.request.ProductRequest;
import com.codemagen.product.dto.response.ProductResponse;
import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponse addProduct(ProductRequest request);
    List<ProductResponse>getAllProducts();
    ProductResponse getProductById(UUID id);
    ProductResponse updateProductById(UUID id, ProductRequest request);
    ProductResponse deleteProduct(UUID id);




}
