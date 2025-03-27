package com.github.erf88.order.integration.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Document(collection = "order")
public record Order(
    @Id String id,
    List<OrderProduct> products,
    OffsetDateTime createdAt,
    String transactionId,
    BigDecimal totalAmount,
    Integer totalItems
) { }
