package com.github.erf88.order.core.dto;

import com.github.erf88.order.integration.document.OrderProduct;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<OrderProduct> products;
}
