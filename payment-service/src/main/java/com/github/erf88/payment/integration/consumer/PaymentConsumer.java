package com.github.erf88.payment.integration.consumer;

import com.github.erf88.payment.core.dto.Event;
import com.github.erf88.payment.core.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.payment-fail}")
    public void consumeFailEvent(String payload) {
        log.info("Receiving rollback event {} from payment-fail topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info("Event: {}", event.toString());
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.payment-success}")
    public void consumeSuccessEvent(String payload) {
        log.info("Receiving success event {} from payment-success topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info("Event: {}", event.toString());
    }
}
