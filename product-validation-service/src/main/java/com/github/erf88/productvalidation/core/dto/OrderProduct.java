package com.github.erf88.productvalidation.core.dto;

import lombok.Data;

@Data
public class OrderProduct {
    private Product product;
    private Integer quantity;
}
