package com.codemagen.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_description")
public class ProductDescription {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name="id", unique = true,nullable = false)
    private UUID id;

    @Column(name="productid",nullable = false)
    public String productid;

    @Column(name="productdescription",nullable=false)
    private String productdescription;






}
