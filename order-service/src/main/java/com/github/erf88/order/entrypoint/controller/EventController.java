package com.github.erf88.order.entrypoint.controller;

import com.github.erf88.order.core.dto.EventResponse;
import com.github.erf88.order.core.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/events")
@RequiredArgsConstructor
@RestController
public class EventController {

    private final EventService eventService;

    @GetMapping("/filter")
    public ResponseEntity<EventResponse> findByFilter(
        @RequestParam(required = false) String orderId,
        @RequestParam(required = false) String transactionId) {
        return new ResponseEntity<>(eventService.findByFilters(orderId, transactionId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> findAll() {
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }
}
