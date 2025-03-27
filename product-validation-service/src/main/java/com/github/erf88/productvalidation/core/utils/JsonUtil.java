package com.github.erf88.productvalidation.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.erf88.productvalidation.core.dto.Event;
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

    public Event toEvent(String json) {
        try {
            return objectMapper.readValue(json, Event.class);
        } catch (Exception e) {
            log.error("Error parsing json to Event", e);
            return null;
        }
    }
}
