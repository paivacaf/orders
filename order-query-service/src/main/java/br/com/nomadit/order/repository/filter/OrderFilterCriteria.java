package br.com.nomadit.order.repository.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class OrderFilterCriteria {
    private String controlNumber;
    private Date registrationDate;
}
