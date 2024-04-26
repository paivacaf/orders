package br.com.nomadit.order.repository.specs;

import br.com.nomadit.order.entity.Order;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class OrderSpecs {

    public static Specification<Order> withControlNumber(String orderNumber) {
        return (root, query, builder) -> builder.equal(root.get("controlNumber"), orderNumber);
    }

    public static Specification<Order> withRegistrationDate(Date registrationDate) {
        return (root, query, builder) -> builder.equal(builder.function("date", Date.class, root.get("registrationDate")), registrationDate);
    }

}
