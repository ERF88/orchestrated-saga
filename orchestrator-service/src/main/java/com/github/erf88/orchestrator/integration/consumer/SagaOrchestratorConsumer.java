package com.github.erf88.orchestrator.integration.consumer;

import com.github.erf88.orchestrator.core.dto.Event;
import com.github.erf88.orchestrator.core.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SagaOrchestratorConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.start-saga}")
    public void consumeStartSagaEvent(String payload) {
        log.info("Receiving event {} from start-saga topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info("Event: {}", event.toString());
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.orchestrator}")
    public void consumeOrchestratorEvent(String payload) {
        log.info("Receiving event {} from orchestrator topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info("Event: {}", event.toString());
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.finish-fail}")
    public void consumeFinishFailEvent(String payload) {
        log.info("Receiving event {} from finish-fail topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info("Event: {}", event.toString());
    }

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.finish-success}")
    public void consumeFinishSuccessEvent(String payload) {
        log.info("Receiving event {} from finish-success topic", payload);
        Event event = jsonUtil.toEvent(payload);
        log.info("Event: {}", event.toString());
    }
}
