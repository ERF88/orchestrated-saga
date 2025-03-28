package com.github.erf88.order.core.service;

import com.github.erf88.order.core.dto.EventRequest;
import com.github.erf88.order.core.dto.EventResponse;
import com.github.erf88.order.core.mapper.EventMapper;
import com.github.erf88.order.infra.exception.ValidationException;
import com.github.erf88.order.integration.document.Event;
import com.github.erf88.order.integration.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class EventService {
    private final EventMapper eventMapper;
    private final EventRepository eventRepository;

    public EventResponse save(EventRequest eventRequest) {
        Event event = eventMapper.toEvent(eventRequest);
        eventRepository.save(event);
        return eventMapper.toEventResponse(event);
    }

    public void notifyEnding(EventRequest eventRequest) {
        EventResponse event = save(eventRequest);
        log.info("Order {} with saga notified! TransactionId: {}", event.getOrderId(), event.getTransactionId());
    }

    public EventResponse findByFilters(String orderId, String transactionId) {
        validateEmptyFilters(orderId, transactionId);
        if(!orderId.isEmpty()) {
            return findByOrderId(orderId);
        } else {
            return findByTransactionId(transactionId);
        }
    }

    private void validateEmptyFilters(String orderId, String transactionId) {
        if (orderId.isEmpty() && transactionId.isEmpty()) {
            throw new ValidationException("OrderId or TransactionId must be informed.");
        }
    }

    private EventResponse findByOrderId(String orderId) {
        return eventRepository.findTop1ByOrderIdOrderByCreatedAtDesc(orderId)
            .map(eventMapper::toEventResponse)
            .orElseThrow(() -> new ValidationException("Event not found by orderId: %s".formatted(orderId)));
    }

    private EventResponse findByTransactionId(String transactionId) {
        return eventRepository.findTop1ByTransactionIdOrderByCreatedAtDesc(transactionId)
            .map(eventMapper::toEventResponse)
            .orElseThrow(() -> new ValidationException("Event not found by transactionId: %s".formatted(transactionId)));
    }

    public List<EventResponse> findAll() {
        return eventRepository.findAllByOrderByCreatedAtDesc()
            .stream()
            .map(eventMapper::toEventResponse)
            .toList();
    }
}
