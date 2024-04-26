package br.com.nomadit.order.repository.specs;

import br.com.nomadit.order.entity.Order;
import org.springframework.data.jpa.domain.Specification;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderSpecs {

    public static Specification<Order> withControlNumber(String orderNumber) {
        return (root, query, builder) -> builder.equal(root.get("controlNumber"), orderNumber);
    }

    public static Specification<Order> withRegistrationDate(LocalDate registrationDate) {
        return (root, query, builder) -> builder.equal(builder.function("date", LocalDate.class, root.get("registrationDate")), Date.valueOf(registrationDate));
    }

}
