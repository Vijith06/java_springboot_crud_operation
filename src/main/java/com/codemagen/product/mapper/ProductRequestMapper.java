package com.codemagen.product.mapper;


import com.codemagen.product.dto.request.ProductDescriptionRequest;
import com.codemagen.product.dto.request.ProductRequest;
import com.codemagen.product.model.ProductDescription;
import com.codemagen.product.model.ProductDetails;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@NoArgsConstructor

@Component
public class ProductRequestMapper {

    public ProductDetails convert(ProductRequest request) {
        ProductDetails product = new ProductDetails();
        product.setId(UUID.randomUUID());// Optional: only use if not auto-generated by DB
        product.setProductid(request.getProductid());
        product.setName(request.getName());
        product.setQty(request.getQty());
        return product;
    }
    public ProductDescription convert(ProductDescriptionRequest request)
    {
        ProductDescription productDescription=new ProductDescription();
        productDescription.setId(UUID.randomUUID());
        productDescription.setProductid(request.getProductid());
        productDescription.setProductdescription(request.getProductdescription());

        return productDescription;


    }
}
