package com.codemagen.product.mapper;

import com.codemagen.product.dto.response.ProductDescriptionResponse;
import com.codemagen.product.dto.response.ProductResponse;
import com.codemagen.product.model.ProductDescription;
import com.codemagen.product.model.ProductDetails;
import com.codemagen.product.handler.StatusDetail;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class ProductResponseMapper {

    public ProductResponse convert(ProductDetails product) {
        StatusDetail statusDetail = new StatusDetail();
        statusDetail.setStatus("Success");
        statusDetail.setMessage("Product retrieved successfully");



        return new ProductResponse(
                product.getId(),
                product.getProductid(),
                product.getName(),
                product.getQty(),

                "SUCCESS",
                statusDetail
        );
    }

    public ProductDescriptionResponse convert(ProductDescription product) {
        StatusDetail statusDetail = new StatusDetail();
        statusDetail.setStatus("Success");
        statusDetail.setMessage("Product retrieved successfully");

        return new ProductDescriptionResponse(
                product.getId(),
                product.getProductid(),
                product.getProductdescription(),
                "SUCCESS",
                statusDetail
        );
    }



}
