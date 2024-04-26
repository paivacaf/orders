package br.com.nomadit.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrderResponse {

    private String controlNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registrationDate;
    private String productName;
    private BigDecimal unitPrice;
    private Integer quantity;
    private Integer clientCode;
    private BigDecimal totalOrder;
}
