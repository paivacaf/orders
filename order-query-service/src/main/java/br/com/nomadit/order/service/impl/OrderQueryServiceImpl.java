package br.com.nomadit.order.service.impl;

import br.com.nomadit.order.dto.OrderResponse;
import br.com.nomadit.order.entity.Order;
import br.com.nomadit.order.exceptions.OrdersNotFoundException;
import br.com.nomadit.order.mapper.OrderMapper;
import br.com.nomadit.order.repository.OrderRepository;
import br.com.nomadit.order.repository.filter.OrderFilterCriteria;
import br.com.nomadit.order.repository.specs.OrderSpecs;
import br.com.nomadit.order.service.OrderQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderQueryServiceImpl implements OrderQueryService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderResponse> search(OrderFilterCriteria filterCriteria) {
        Specification<Order> specification = Specification.where(null);

        if (filterCriteria.getControlNumber() != null) {
            specification = specification.and(OrderSpecs.withControlNumber(filterCriteria.getControlNumber()));
        }
        if (filterCriteria.getRegistrationDate() != null) {
            specification = specification.and(OrderSpecs.withRegistrationDate(filterCriteria.getRegistrationDate()));
        }

        List<Order> orders = orderRepository.findAll(specification);

        List<OrderResponse> responses = orders.stream().map(orderMapper::toResponse).collect(Collectors.toList());

        if (responses.isEmpty())
            throw new OrdersNotFoundException();

        return responses;
    }

}
