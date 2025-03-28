package com.github.erf88.order.core.dto;

import com.github.erf88.order.integration.document.Event;
import com.github.erf88.order.integration.document.History;
import com.github.erf88.order.integration.document.Order;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class EventRequest {
    private String transactionId;
    private String orderId;
    private Order payload;
    private String source;
    private String status;
    private List<History> eventHistory;
    private OffsetDateTime createdAt;

    public EventRequest(Order order) {
        this.transactionId = order.getTransactionId();
        this.orderId = order.getId();
        this.payload = order;
    }

    public Event toEvent() {
        return Event.builder()
            .orderId(this.orderId)
            .transactionId(this.transactionId)
            .payload(this.payload)
            .createdAt(OffsetDateTime.now())
            .build();
    }
}
