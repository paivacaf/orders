package br.com.nomadit.order.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "control_number")
    private String controlNumber;
    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "client_code")
    private Integer clientCode;

    @Column(name = "total_order")
    private BigDecimal totalOrder;

}
