package com.codemagen.product.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDescriptionRequest {
    private String productid;
    private String productdescription;
}
