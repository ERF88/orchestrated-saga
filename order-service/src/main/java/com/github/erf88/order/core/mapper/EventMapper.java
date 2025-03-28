package com.github.erf88.order.core.mapper;

import com.github.erf88.order.core.dto.EventRequest;
import com.github.erf88.order.core.dto.EventResponse;
import com.github.erf88.order.integration.document.Event;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class EventMapper {

    public Event toEvent(EventRequest eventRequest) {
        return Event.builder()
            .orderId(eventRequest.getOrderId())
            .transactionId(eventRequest.getTransactionId())
            .payload(eventRequest.getPayload())
            .createdAt(OffsetDateTime.now())
            .build();
    }

    public EventResponse toEventResponse(Event event) {
        EventResponse eventResponse = new EventResponse();
        BeanUtils.copyProperties(event, eventResponse);
        return eventResponse;
    }
}
