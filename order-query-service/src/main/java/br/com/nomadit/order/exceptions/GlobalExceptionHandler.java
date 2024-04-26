package br.com.nomadit.order.exceptions;

import org.springframework.core.convert.ConversionFailedException;
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

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<String> handleConversionFailedException(ConversionFailedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Erro de conversão: " + ex.getMessage());
    }

}
