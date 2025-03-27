package com.github.erf88.inventory.integration.consumer;

import com.github.erf88.inventory.core.dto.Event;
import com.github.erf88.inventory.core.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class InventoryConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.inventory-fail}")
    public void consumeFailEvent(String payload) {
        log.info("Receiving rollback event {} from inventory-fail topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info("Event: {}", event.toString());
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.inventory-success}")
    public void consumeSuccessEvent(String payload) {
        log.info("Receiving success event {} from inventory-success topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info("Event: {}", event.toString());
    }
}
