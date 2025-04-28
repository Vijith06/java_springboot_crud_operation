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
@Table(name = "product")
public class ProductDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name="id", unique = true,nullable = false)
    private UUID id;

    @Column(name="productid",nullable=false)
    public String productid;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="qty",nullable = false)
    private int qty;




}
