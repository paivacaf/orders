package br.com.nomadit.order.exceptions;

import br.com.nomadit.order.dto.OrderErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        return new ResponseEntity<>("Erro interno do servidor: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de validação: " + e.getMessage());
    }

    @ExceptionHandler(OrderProcessingException.class)
    public ResponseEntity<OrderErrorResponse> handleOrderProcessingException(OrderProcessingException ex) {
        OrderErrorResponse errorResponse = ex.getResponse();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxOrderLimitExceededException.class)
    public ResponseEntity<String> handleOrderProcessingException(MaxOrderLimitExceededException ex) {
        String errorResponse = ex.getMessage();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
