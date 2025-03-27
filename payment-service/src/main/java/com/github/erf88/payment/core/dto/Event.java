package com.github.erf88.payment.core.dto;

import com.github.erf88.payment.core.enums.SagaStatus;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Event {
    private String id;
    private String transactionId;
    private String orderId;
    private Order payload;
    private String source;
    private SagaStatus status;
    private List<History> eventHistory;
    private OffsetDateTime createdAt;
}


