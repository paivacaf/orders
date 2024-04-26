package br.com.nomadit.order.controller;

import br.com.nomadit.order.dto.OrderResponse;
import br.com.nomadit.order.entity.Order;
import br.com.nomadit.order.repository.filter.OrderFilterCriteria;
import br.com.nomadit.order.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/orders/v1")
@ConditionalOnProperty(name = "app.write.enabled", havingValue = "false")
public class OrderQueryController {

    @Autowired
    private OrderQueryService orderQueryService;

    @GetMapping
    public List<OrderResponse> getOrders(
            @RequestParam(required = false) String controlNumber,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate registrationDate) {



        return orderQueryService.search(OrderFilterCriteria.builder()
                        .controlNumber(controlNumber)
                        .registrationDate(registrationDate)
                .build());
    }

}
