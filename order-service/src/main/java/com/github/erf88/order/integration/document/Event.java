package com.github.erf88.order.integration.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@NoArgsConstructor
@ToString
@Document(collection = "event")
public class Event {
    @Id
    private String id;
    private String orderId;
    private String transactionId;
    private Order payload;
    private String source;
    private String status;
    private List<History> eventHistory;
    private OffsetDateTime createdAt;
}
