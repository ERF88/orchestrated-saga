package com.github.erf88.productvalidation.core.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String code;
    private BigDecimal unitValue;
}
