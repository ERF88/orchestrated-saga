package com.github.erf88.order.core.service;

import com.github.erf88.order.integration.document.Event;
import com.github.erf88.order.integration.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event save(Event event) {
        return eventRepository.save(event);
    }
}
