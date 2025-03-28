package com.github.erf88.order.integration.consumer;

import com.github.erf88.order.core.dto.EventRequest;
import com.github.erf88.order.core.service.EventService;
import com.github.erf88.order.core.utils.JsonUtil;
import com.github.erf88.order.integration.document.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class EventConsumer {
    private final EventService eventService;
    private final JsonUtil jsonUtil;

    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.notify-ending}")
    public void consumeNotifyEndingEvent(String payload) {
        log.info("Receiving ending notification event {} from notify-ending topic", payload);
        EventRequest eventRequest = jsonUtil.toEventRequest(payload);
        eventService.notifyEnding(eventRequest);
    }
}
