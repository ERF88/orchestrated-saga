package com.github.erf88.productvalidation.core.dto;

import com.github.erf88.productvalidation.core.enums.SagaStatus;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class History {
    private String source;
    private SagaStatus status;
    private String message;
    private OffsetDateTime createdAt;
}
