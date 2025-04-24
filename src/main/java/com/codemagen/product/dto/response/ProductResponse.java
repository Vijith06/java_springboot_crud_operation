package com.codemagen.product.dto.response;


import com.codemagen.product.handler.StatusDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private UUID id;
    private String productid;
    private String name;
    private int qty;

    private String status;                // To store SUCCESS/FAILURE
    private StatusDetail statusDetail;   // To store detailed status like code/message
}
