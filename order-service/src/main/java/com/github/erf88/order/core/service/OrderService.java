package com.github.erf88.order.core.service;

import com.github.erf88.order.core.dto.EventRequest;
import com.github.erf88.order.core.dto.EventResponse;
import com.github.erf88.order.core.dto.OrderRequest;
import com.github.erf88.order.core.dto.OrderResponse;
import com.github.erf88.order.core.mapper.OrderMapper;
import com.github.erf88.order.core.utils.JsonUtil;
import com.github.erf88.order.integration.document.Order;
import com.github.erf88.order.integration.producer.SagaProducer;
import com.github.erf88.order.integration.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final EventService eventService;
    private final JsonUtil jsonUtil;
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final SagaProducer sagaProducer;

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = orderMapper.toOrder(orderRequest);
        orderRepository.save(order);
        String payload = createPayload(order);
        sagaProducer.sendEvent(payload);
        return orderMapper.toOrderResponse(order);
    }

    private String createPayload(Order order) {
        EventRequest eventRequest = new EventRequest(order.getTransactionId(), order.getId(), order);
        EventResponse event = eventService.save(eventRequest);
        return jsonUtil.toJson(event);
    }
}
