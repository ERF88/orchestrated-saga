package com.github.erf88.order.integration.document;

public record OrderProduct(
    Product product,
    Integer quantity
) { }
