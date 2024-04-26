package br.com.nomadit.order.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class OrderErrorResponse {
    private List<OrderResponse> responses;
}
