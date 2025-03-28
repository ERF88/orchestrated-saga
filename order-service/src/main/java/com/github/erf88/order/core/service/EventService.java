package com.github.erf88.order.core.service;

import com.github.erf88.order.core.dto.EventRequest;
import com.github.erf88.order.integration.document.Event;
import com.github.erf88.order.integration.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveCallback;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@RequiredArgsConstructor
@Service
@Slf4j
public class EventService {
    private final EventRepository eventRepository;

    public Event save(EventRequest eventRequest) {
        Event event = eventRequest.toEvent();
        return eventRepository.save(event);
    }

    public void notifyEnding(EventRequest eventRequest) {
        Event event = save(eventRequest);
        log.info("Order {} with saga notified! TransactionId: {}", event.getOrderId(), event.getTransactionId());
    }
}
