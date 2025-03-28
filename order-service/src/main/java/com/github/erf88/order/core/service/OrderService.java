package com.github.erf88.order.core.service;

import com.github.erf88.order.core.dto.OrderRequest;
import com.github.erf88.order.core.utils.JsonUtil;
import com.github.erf88.order.integration.document.Event;
import com.github.erf88.order.integration.document.Order;
import com.github.erf88.order.integration.producer.SagaProducer;
import com.github.erf88.order.integration.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;

import static com.github.erf88.order.core.constants.OrderConstants.TRANSACTION_ID_PATTERN;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final EventService eventService;
    private final JsonUtil jsonUtil;
    private final OrderRepository orderRepository;
    private final SagaProducer sagaProducer;

    public Order createOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
            .products(orderRequest.getProducts())
            .createdAt(OffsetDateTime.now())
            .transactionId(String.format(TRANSACTION_ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()))
            .build();
        orderRepository.save(order);
        String payload = createPayload(order);
        sagaProducer.sendEvent(payload);
        return order;
    }

    private String createPayload(Order order) {
        Event event = Event.builder()
            .orderId(order.getId())
            .transactionId(order.getTransactionId())
            .payload(order)
            .createdAt(OffsetDateTime.now())
            .build();
        eventService.save(event);
        return jsonUtil.toJson(event);
    }
}
