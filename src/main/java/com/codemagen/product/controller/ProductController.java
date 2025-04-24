package com.codemagen.product.controller;


import com.codemagen.product.contants.EndPointConstants;
import com.codemagen.product.dto.request.ProductRequest;
import com.codemagen.product.dto.response.ProductResponse;
import com.codemagen.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.codemagen.product.contants.EndPointConstants.BASE_URL;
import io.swagger.annotations.Api;

import java.util.List;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping(value = BASE_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Product Controller", produces = MediaType.APPLICATION_JSON_VALUE)

public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping(value = EndPointConstants.ADD_PRODUCT)
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request) {
        log.info("Add Product request received");
        ProductResponse response = service.addProduct(request);
        log.info("Product added successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = EndPointConstants.GET_ALL_PRODUCTS)
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        log.info("Get All Products request received");
        List<ProductResponse> responses = service.getAllProducts();
        log.info("Fetched {} products", responses.size());
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping(value = EndPointConstants.GET_PRODUCT_BY_ID)
    public ResponseEntity<ProductResponse> getProductById(@PathVariable UUID id) {
        log.info("Get Product by ID request received for ID: {}", id);
        ProductResponse response = service.getProductById(id);
        log.info("Fetched product details for ID: {}", id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = EndPointConstants.DELETE_PRODUCT_BY_ID)
    public ResponseEntity<ProductResponse> deleteProduct(@PathVariable UUID id) {
        log.info("Delete Product request received for ID: {}", id);
        ProductResponse response = service.deleteProduct(id);
        log.info("Product with ID: {} has been deleted", id);
        return new ResponseEntity<>(response,HttpStatus.OK); // HTTP 204 No Content
    }

    @PutMapping(value = EndPointConstants.UPDATE_PRODUCT_BY_ID)
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable UUID id, @RequestBody ProductRequest request) {
        log.info("Update Product request received for ID: {}", id);
        ProductResponse response = service.updateProductById(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }






}