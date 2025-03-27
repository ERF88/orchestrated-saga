package com.github.erf88.orchestrator.core.dto;

import com.github.erf88.orchestrator.core.enums.EventSource;
import com.github.erf88.orchestrator.core.enums.SagaStatus;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class Event {
    private String id;
    private String transactionId;
    private String orderId;
    private Order payload;
    private EventSource source;
    private SagaStatus status;
    private List<History> eventHistory;
    private OffsetDateTime createdAt;
}


