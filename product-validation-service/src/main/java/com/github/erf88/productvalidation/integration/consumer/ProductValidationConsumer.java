package com.github.erf88.productvalidation.integration.consumer;

import com.github.erf88.productvalidation.core.dto.Event;
import com.github.erf88.productvalidation.core.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductValidationConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.product-validation-fail}")
    public void consumeFailEvent(String payload) {
        log.info("Receiving rollback event {} from product-validation-fail topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info("Event: {}", event.toString());
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.product-validation-success}")
    public void consumeSuccessEvent(String payload) {
        log.info("Receiving success event {} from product-validation-success topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info("Event: {}", event.toString());
    }
}
