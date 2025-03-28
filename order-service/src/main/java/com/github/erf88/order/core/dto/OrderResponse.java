package com.github.erf88.order.core.dto;

import com.github.erf88.order.integration.document.OrderProduct;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private String id;
    private List<OrderProduct> products;
    private OffsetDateTime createdAt;
    private String transactionId;
    private BigDecimal totalAmount;
    private Integer totalItems;
}
