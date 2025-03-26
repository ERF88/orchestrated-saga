package com.github.erf88.orchestrator.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Topics {

    START_SAGA("start-saga"),
    ORCHESTRATOR("orchestrator"),
    FINISH_SUCCESS("finish-success"),
    FINISH_FAIL("finish-fail"),
    PRODUCT_VALIDATION_FAIL("product-validation-fail"),
    PRODUCT_VALIDATION_SUCCESS("product-validation-success"),
    PAYMENT_FAIL("payment-fail"),
    PAYMENT_SUCCESS("payment-success"),
    INVENTORY_FAIL("inventory-fail"),
    INVENTORY_SUCCESS("inventory-success"),
    NOTIFY_ENDING("notify-ending");

    private final String topic;
}
