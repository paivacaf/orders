package br.com.nomadit.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderResponse {
    private String controlNumber;
    private String message;
    @JsonIgnore
    private boolean error;
}
