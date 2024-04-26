package br.com.nomadit.order.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
@Data
public class OrderRequest {

    @Size(max = 10)
    /*@Pattern(regexp = "^0*[1-9][0-9]*$")*/
    private String controlNumber;
    private LocalDate registrationDate;
    private String productName;
    private BigDecimal unitPrice;
    private Integer quantity;
    private Integer clientCode;
}
