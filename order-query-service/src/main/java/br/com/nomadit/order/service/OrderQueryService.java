package br.com.nomadit.order.service;

import br.com.nomadit.order.dto.OrderResponse;
import br.com.nomadit.order.entity.Order;
import br.com.nomadit.order.repository.filter.OrderFilterCriteria;

import java.util.List;

public interface OrderQueryService {

    public List<OrderResponse> search(OrderFilterCriteria filterCriteria);
}
