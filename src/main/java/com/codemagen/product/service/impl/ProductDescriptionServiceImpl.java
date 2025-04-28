package com.codemagen.product.service.impl;

import com.codemagen.product.contants.MessageConstants;
import com.codemagen.product.contants.ResponseStatusConstants;
import com.codemagen.product.dao.ProductDescriptionDao;
import com.codemagen.product.dto.request.ProductDescriptionRequest;
import com.codemagen.product.dto.response.ProductDescriptionResponse;
import com.codemagen.product.handler.StatusDetail;
import com.codemagen.product.mapper.ProductRequestMapper;
import com.codemagen.product.mapper.ProductResponseMapper;
import com.codemagen.product.model.ProductDescription;
import com.codemagen.product.service.ProductDescriptionService;
import com.codemagen.product.service.WeatherService;
import com.codemagen.product.validator.ProductDescriptionValidator;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {
    private final ProductDescriptionDao productDescriptionDao;

    private final ProductRequestMapper productRequestMapper;
    private final ProductResponseMapper productResponseMapper;

    private final StatusDetail statusDetail = new StatusDetail();

    @Autowired
    public ProductDescriptionServiceImpl(ProductDescriptionDao productDescriptionDAO,
                                         ProductRequestMapper productRequestMapper,
                                         ProductResponseMapper productResponseMapper) {
        this.productDescriptionDao = productDescriptionDAO;
        this.productRequestMapper = productRequestMapper;
        this.productResponseMapper = productResponseMapper;
    }


    @Override
    public ProductDescriptionResponse addProductDescription(ProductDescriptionRequest request) {
        ProductDescriptionResponse response = new ProductDescriptionResponse();

        // Validate input
        ProductDescriptionValidator.validateRequest(request);

        // Convert request to entity
        ProductDescription product = productRequestMapper.convert(request);

        // Save to DB
        ProductDescription savedDescripiton = productDescriptionDao.saveDescription(product);

        // Convert back to response
        response = productResponseMapper.convert(savedDescripiton);

        // Attach status info
        response.setStatus(ResponseStatusConstants.SUCCESS);
        statusDetail.setStatus(ResponseStatusConstants.SUCCESS_STATUS);
        statusDetail.setMessage(MessageConstants.SUCCESS_DESC);
        response.setStatusDetail(statusDetail);

        return response;
    }



}
