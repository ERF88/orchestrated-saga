package com.github.erf88.order.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.erf88.order.core.dto.EventRequest;
import com.github.erf88.order.integration.document.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JsonUtil {
    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("Error parsing object to json", e);
            return "";
        }
    }

    public EventRequest toEventRequest(String json) {
        try {
            return objectMapper.readValue(json, EventRequest.class);
        } catch (Exception e) {
            log.error("Error parsing json to Event", e);
            return null;
        }
    }
}
