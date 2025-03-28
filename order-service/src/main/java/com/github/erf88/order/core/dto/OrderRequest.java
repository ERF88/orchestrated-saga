package com.github.erf88.order.core.dto;

import com.github.erf88.order.integration.document.Order;
import com.github.erf88.order.integration.document.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static com.github.erf88.order.core.constants.OrderConstants.TRANSACTION_ID_PATTERN;

@Data
public class OrderRequest {
    private List<OrderProduct> products;

    public Order toOrder() {
        return Order.builder()
            .products(this.products)
            .createdAt(OffsetDateTime.now())
            .transactionId(String.format(TRANSACTION_ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()))
            .build();
    }
}
