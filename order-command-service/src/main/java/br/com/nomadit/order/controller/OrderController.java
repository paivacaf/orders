package br.com.nomadit.order.controller;

import br.com.nomadit.order.dto.OrderRequest;
import br.com.nomadit.order.dto.OrderResponse;
import br.com.nomadit.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RequestMapping("/orders/v1")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<List<OrderResponse>> receiveOrders(@Valid @RequestBody List<OrderRequest> orders) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderService.processOrders(orders));
    }
}