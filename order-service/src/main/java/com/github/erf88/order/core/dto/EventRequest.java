package com.github.erf88.order.core.dto;

import com.github.erf88.order.integration.document.History;
import com.github.erf88.order.integration.document.Order;
import lombok.Data;

import java.util.List;

@Data
public class EventRequest {
    private String transactionId;
    private String orderId;
    private Order payload;
    private String source;
    private String status;
    private List<History> eventHistory;

    public EventRequest(String transactionId, String orderId, Order order) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.payload = order;
    }
}
