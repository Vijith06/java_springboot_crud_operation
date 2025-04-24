package com.codemagen.product.dto.response;

import com.codemagen.product.handler.StatusDetail;
import com.codemagen.product.model.ProductDescription;
import com.codemagen.product.model.ProductDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDescriptionResponse {
    private UUID id;
    private String productid;
    private String productdescription;

    private String status;                // To store SUCCESS/FAILURE
    private StatusDetail statusDetail;

}
