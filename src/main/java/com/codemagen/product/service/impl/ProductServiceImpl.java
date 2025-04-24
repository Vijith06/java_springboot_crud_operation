package com.codemagen.product.service.impl;


import com.codemagen.product.contants.MessageConstants;
import com.codemagen.product.contants.ResponseStatusConstants;
import com.codemagen.product.dao.ProductDao;
import com.codemagen.product.dto.request.ProductRequest;
import com.codemagen.product.dto.response.ProductResponse;
import com.codemagen.product.handler.StatusDetail;
import com.codemagen.product.mapper.ProductRequestMapper;
import com.codemagen.product.mapper.ProductResponseMapper;
import com.codemagen.product.model.ProductDescription;
import com.codemagen.product.model.ProductDetails;
import com.codemagen.product.service.ProductService;
import com.codemagen.product.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDAO;

    private final ProductRequestMapper productRequestMapper;
    private final ProductResponseMapper productResponseMapper;

    private final StatusDetail statusDetail = new StatusDetail();

    @Autowired
    public ProductServiceImpl(ProductDao productDAO,
                              ProductRequestMapper productRequestMapper,
                              ProductResponseMapper productResponseMapper) {
        this.productDAO = productDAO;
        this.productRequestMapper = productRequestMapper;
        this.productResponseMapper = productResponseMapper;
    }

    @Override
    public ProductResponse addProduct(ProductRequest request) {
        ProductResponse response = new ProductResponse();

        // Validate input
        ProductValidator.validateRequest(request);

        // Convert request to entity
        ProductDetails product = productRequestMapper.convert(request);

        // Save to DB
        ProductDetails savedProduct = productDAO.saveProduct(product);

        // Convert back to response
        response = productResponseMapper.convert(savedProduct);

        // Attach status info
        response.setStatus(ResponseStatusConstants.SUCCESS);
        statusDetail.setStatus(ResponseStatusConstants.SUCCESS_STATUS);
        statusDetail.setMessage(MessageConstants.SUCCESS_DESC);
        response.setStatusDetail(statusDetail);

        return response;
    }

    @Override
    public ProductResponse updateProductById(UUID id, ProductRequest request) {
        ProductDetails existing = productDAO.getProductById(id);
        if (existing == null) {
            throw new RuntimeException("Product not found with ID: " + id);
        }

        // Update only required fields
        existing.setName(request.getName());
        existing.setQty(request.getQty());

        ProductDetails saved = productDAO.updateProduct(existing);
        ProductResponse response = productResponseMapper.convert(saved);

        response.setStatus(ResponseStatusConstants.SUCCESS);
        StatusDetail status = new StatusDetail();
        status.setStatus(ResponseStatusConstants.SUCCESS_STATUS);
        status.setMessage(MessageConstants.SUCCESS_DESC);
        response.setStatusDetail(status);

        return response;
    }


    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductDetails> productList = productDAO.getAllProducts();
        return productList.stream()
                .map(productResponseMapper::convert)
                .peek(resp -> {
                    resp.setStatus(ResponseStatusConstants.SUCCESS);
                    StatusDetail status = new StatusDetail();
                    status.setStatus(ResponseStatusConstants.SUCCESS_STATUS);
                    status.setMessage(MessageConstants.SUCCESS_DESC);
                    resp.setStatusDetail(status);
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(UUID id) {
        ProductDetails product = productDAO.getProductById(id);

        if (product == null) {
            // Handle not found scenario (custom exception recommended)
            throw new RuntimeException("Product not found with ID: " + id);
        }

        ProductResponse response = productResponseMapper.convert(product);
        response.setStatus(ResponseStatusConstants.SUCCESS);
        statusDetail.setStatus(ResponseStatusConstants.SUCCESS_STATUS);
        statusDetail.setMessage(MessageConstants.SUCCESS_DESC);
        response.setStatusDetail(statusDetail);

        return response;
    }

    @Override
    public ProductResponse deleteProduct(UUID id) {
        ProductDetails product = productDAO.getProductById(id);
        if (product == null) {
            throw new RuntimeException("Product not found with ID: " + id);
        }

        productDAO.deleteProduct(id);

        ProductResponse response = productResponseMapper.convert(product);
        response.setStatus(ResponseStatusConstants.SUCCESS);
        statusDetail.setStatus(ResponseStatusConstants.SUCCESS_STATUS);
        statusDetail.setMessage(MessageConstants.SUCCESS_DESC);
        response.setStatusDetail(statusDetail);

        return response;
    }


}
