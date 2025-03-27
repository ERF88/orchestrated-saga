package com.github.erf88.order.integration.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SagaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.start-saga}")
    private String startSaga;

    public void sendEvent(String payload) {
        try {
            log.info("Sending event to topic {} with data {}", startSaga, payload);
            kafkaTemplate.send(startSaga, payload);
        } catch (Exception e) {
            log.error("Error trying to send data to topic {} with data {}", startSaga, payload, e);
        }
    }
}
