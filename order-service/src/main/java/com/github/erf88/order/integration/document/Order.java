package com.github.erf88.order.integration.document;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public record Order(
    String id,
    List<OrderProduct> products,
    OffsetDateTime createdAt,
    String transactionId,
    BigDecimal totalAmount,
    Integer totalItems
) { }
