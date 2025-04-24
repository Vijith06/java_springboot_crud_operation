package com.codemagen.product.validator;

import com.codemagen.product.dto.request.ProductDescriptionRequest;

public class ProductDescriptionValidator {

    public static void validateRequest(ProductDescriptionRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Product request cannot be null.");
        }
        if (request.getProductid() == null || request.getProductid().isEmpty()) {
            throw new IllegalArgumentException("Product ID is required.");
        }

        if (request.getProductdescription() == null || request.getProductdescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Product descritpion  is required.");
        }
    }
}
