package br.com.nomadit.order.repository.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class OrderFilterCriteria {
    private String controlNumber;
    private LocalDate registrationDate;
}
