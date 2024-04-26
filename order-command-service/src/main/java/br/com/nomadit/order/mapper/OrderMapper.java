package br.com.nomadit.order.mapper;

import br.com.nomadit.order.dto.OrderRequest;
import br.com.nomadit.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface OrderMapper {

	@Mapping(target = "quantity", source = "quantity", defaultValue = "0")
	Order toEntity(OrderRequest request);
}