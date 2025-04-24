package com.codemagen.product.repository;

import com.codemagen.product.model.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, UUID> {

}
