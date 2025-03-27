package com.github.erf88.orchestrator.core.dto;

import com.github.erf88.orchestrator.core.enums.EventSource;
import com.github.erf88.orchestrator.core.enums.SagaStatus;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class History {
    private EventSource source;
    private SagaStatus status;
    private String message;
    private OffsetDateTime createdAt;
}
