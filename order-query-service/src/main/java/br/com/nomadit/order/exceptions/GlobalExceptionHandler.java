package br.com.nomadit.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrdersNotFoundException.class)
    public ResponseEntity<String> handleOrdersNotFoundException(OrdersNotFoundException ex) {
        String errorResponse = ex.getMessage();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
