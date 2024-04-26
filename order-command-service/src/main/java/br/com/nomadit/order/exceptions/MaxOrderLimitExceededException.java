package br.com.nomadit.order.exceptions;

public class MaxOrderLimitExceededException extends RuntimeException {
    public MaxOrderLimitExceededException(String message) {
        super(message);
    }
}