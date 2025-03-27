package com.github.erf88.order.integration.document;

import java.time.OffsetDateTime;

public record History(
    String source,
    String status,
    String message,
    OffsetDateTime createdAt
) {
}
