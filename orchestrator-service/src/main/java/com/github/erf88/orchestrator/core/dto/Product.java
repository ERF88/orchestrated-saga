package com.github.erf88.orchestrator.core.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String code;
    private BigDecimal unitValue;
}
