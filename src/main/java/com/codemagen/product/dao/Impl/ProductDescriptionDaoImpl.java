package com.codemagen.product.dao.Impl;

import com.codemagen.product.dao.ProductDescriptionDao;
import com.codemagen.product.model.ProductDescription;
import com.codemagen.product.repository.ProductDescriptionRepository;
import com.codemagen.product.mapper.ProductResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDescriptionDaoImpl implements ProductDescriptionDao {

    @Autowired
    private ProductDescriptionRepository repository;

    @Autowired
    private ProductResponseMapper productResponseMapper; // Inject ProductResponseMapper here

    @Override
    public ProductDescription saveDescription(ProductDescription product) {
        return repository.save(product);
    }




}
