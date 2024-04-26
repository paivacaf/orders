package br.com.nomadit.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrdersNotFoundException extends RuntimeException {
    public OrdersNotFoundException() {
        super("Nenhum pedido encontrado");
    }
}
