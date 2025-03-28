package com.github.erf88.order.integration.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;


@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@NoArgsConstructor
@ToString
@Document(collection = "order")
public class Order  {
    @Id
    private String id;
    private List<OrderProduct> products;
    private OffsetDateTime createdAt;
    private String transactionId;
    private BigDecimal totalAmount;
    private Integer totalItems;
}
