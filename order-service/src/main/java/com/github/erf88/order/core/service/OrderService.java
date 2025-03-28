package com.github.erf88.order.core.service;

import com.github.erf88.order.core.dto.EventRequest;
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
        Order order = orderRequest.toOrder();
        orderRepository.save(order);
        String payload = createPayload(order);
        sagaProducer.sendEvent(payload);
        return order;
    }

    private String createPayload(Order order) {
        EventRequest eventRequest = new EventRequest(order);
        eventService.save(eventRequest);
        Event event = eventService.save(eventRequest);
        return jsonUtil.toJson(event);
    }
}
