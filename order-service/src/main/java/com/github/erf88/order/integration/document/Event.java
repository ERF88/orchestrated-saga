package com.github.erf88.order.integration.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.List;

@Document(collection = "event")
public record Event(
    @Id String id,
    String transactionId,
    String orderId,
    Order payload,
    String source,
    String status,
    List<History> eventHistory,
    OffsetDateTime createdAt
) {
}
