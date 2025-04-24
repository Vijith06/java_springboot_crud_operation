package com.codemagen.product.validator;

import com.codemagen.product.dto.request.ProductRequest;
import com.codemagen.product.mapper.ProductRequestMapper;

public class ProductValidator {
    public static void validateRequest(ProductRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Product request cannot be null.");
        }
        if (request.getProductid() == null || request.getProductid().isEmpty()) {
            throw new IllegalArgumentException("Product ID is required.");
        }

        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name is required.");
        }

        if (request.getQty() < 0) {
            throw new IllegalArgumentException("Product quantity cannot be negative.");
        }
    }
}
