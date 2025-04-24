package com.codemagen.product.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDescriptionDto {
    private UUID id;
    private String productid;
    private String productdescription;

}
