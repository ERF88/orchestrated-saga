package com.github.erf88.order.core.dto;

import com.github.erf88.order.integration.document.History;
import com.github.erf88.order.integration.document.Order;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class EventResponse {
    private String id;
    private String transactionId;
    private String orderId;
    private Order payload;
    private String source;
    private String status;
    private List<History> eventHistory;
    private OffsetDateTime createdAt;
}
