package br.com.nomadit.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderResponse {

    private String controlNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private Date registrationDate;
    private String productName;
    private BigDecimal unitPrice;
    private Integer quantity;
    private Integer clientCode;
    private BigDecimal totalOrder;
}
