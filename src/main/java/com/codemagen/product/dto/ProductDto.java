package com.codemagen.product.dto;


import com.codemagen.product.handler.StatusDetail;
import com.codemagen.product.model.ProductDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private UUID id;
    private String productid;
    private String name;
    private int qty;



}
