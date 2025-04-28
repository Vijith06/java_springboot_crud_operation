package com.codemagen.product.controller;


import com.codemagen.product.contants.EndPointConstants;
import com.codemagen.product.dto.request.ProductDescriptionRequest;
import com.codemagen.product.dto.response.ProductDescriptionResponse;
import com.codemagen.product.service.ProductDescriptionService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.codemagen.product.contants.EndPointConstants.BASE_URL;

@Slf4j
@RestController
@RequestMapping(value = BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Product Description Controller", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductDescriptionController {

    @Autowired
    private ProductDescriptionService service;

    @PostMapping(value = EndPointConstants.ADD_DESCRIPTION)
    public ResponseEntity<ProductDescriptionResponse> addProductDescription(@RequestBody ProductDescriptionRequest request) {
        log.info("Add Product Descripiton request received");
        ProductDescriptionResponse response = service.addProductDescription(request);
        log.info("Product descripiton added successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
