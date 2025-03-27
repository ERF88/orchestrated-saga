package com.github.erf88.orchestrator.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Topics {

    START_SAGA("start-saga"),
    ORCHESTRATOR("orchestrator"),
    FINISH_FAIL("finish-fail"),
    FINISH_SUCCESS("finish-success"),
    PRODUCT_VALIDATION_FAIL("product-validation-fail"),
    PRODUCT_VALIDATION_SUCCESS("product-validation-success"),
    PAYMENT_FAIL("payment-fail"),
    PAYMENT_SUCCESS("payment-success"),
    INVENTORY_FAIL("inventory-fail"),
    INVENTORY_SUCCESS("inventory-success"),
    NOTIFY_ENDING("notify-ending");

    private final String topic;
}
