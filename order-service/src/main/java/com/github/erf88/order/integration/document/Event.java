package com.github.erf88.order.integration.document;

import java.time.OffsetDateTime;
import java.util.List;

public record Event(
    String id,
    String transactionId,
    String orderId,
    Order payload,
    String source,
    String status,
    List<History> eventHistory,
    OffsetDateTime createdAt
) {
}
