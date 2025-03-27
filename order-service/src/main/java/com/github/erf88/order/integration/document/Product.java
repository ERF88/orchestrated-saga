package com.github.erf88.order.integration.document;

import java.math.BigDecimal;

public record Product(
    String code,
    BigDecimal unitValue
) { }
