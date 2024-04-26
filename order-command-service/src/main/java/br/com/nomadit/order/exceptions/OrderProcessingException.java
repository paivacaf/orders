package br.com.nomadit.order.exceptions;

import br.com.nomadit.order.dto.OrderErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderProcessingException extends RuntimeException {

    private OrderErrorResponse response;

    public OrderProcessingException(OrderErrorResponse response) {
        this.response = response;
    }

}