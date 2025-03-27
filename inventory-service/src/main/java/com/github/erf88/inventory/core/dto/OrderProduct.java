package com.github.erf88.inventory.core.dto;

import lombok.Data;

@Data
public class OrderProduct {
    private Product product;
    private Integer quantity;
}
