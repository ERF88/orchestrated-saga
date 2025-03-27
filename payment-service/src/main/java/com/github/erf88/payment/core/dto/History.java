package com.github.erf88.payment.core.dto;

import com.github.erf88.payment.core.enums.SagaStatus;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class History {
    private String source;
    private SagaStatus status;
    private String message;
    private OffsetDateTime createdAt;
}
