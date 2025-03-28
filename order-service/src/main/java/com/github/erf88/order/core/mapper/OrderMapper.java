package com.github.erf88.order.core.mapper;

import com.github.erf88.order.core.dto.OrderRequest;
import com.github.erf88.order.core.dto.OrderResponse;
import com.github.erf88.order.integration.document.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;

import static com.github.erf88.order.core.constants.OrderConstants.TRANSACTION_ID_PATTERN;

@Component
public class OrderMapper {
    public Order toOrder(OrderRequest orderRequest) {
        return Order.builder()
            .products(orderRequest.getProducts())
            .createdAt(OffsetDateTime.now())
            .transactionId(String.format(TRANSACTION_ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()))
            .build();
    }

    public OrderResponse toOrderResponse(Order order) {
        OrderResponse orderResponse = new OrderResponse();
        BeanUtils.copyProperties(order, orderResponse);
        return orderResponse;
    }
}
