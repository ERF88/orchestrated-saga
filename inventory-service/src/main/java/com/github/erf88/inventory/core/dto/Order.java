package com.github.erf88.inventory.core.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Order {
    private String id;
    private List<OrderProduct> products;
    private OffsetDateTime createdAt;
    private String transactionId;
    private BigDecimal totalAmount;
    private Integer totalItems;
}
