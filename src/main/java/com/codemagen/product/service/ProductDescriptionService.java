package com.codemagen.product.service;

import com.codemagen.product.dto.request.ProductDescriptionRequest;
import com.codemagen.product.dto.response.ProductDescriptionResponse;
import com.codemagen.product.dto.response.ProductResponse;
import com.codemagen.product.model.ProductDescription;

import java.util.List;
import java.util.UUID;

public interface ProductDescriptionService {
    ProductDescriptionResponse addProductDescription(ProductDescriptionRequest request);
}
