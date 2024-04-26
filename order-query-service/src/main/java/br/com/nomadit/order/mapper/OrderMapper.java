package br.com.nomadit.order.mapper;

import br.com.nomadit.order.dto.OrderResponse;
import br.com.nomadit.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface OrderMapper {
	
	OrderResponse toResponse(Order entity);
}