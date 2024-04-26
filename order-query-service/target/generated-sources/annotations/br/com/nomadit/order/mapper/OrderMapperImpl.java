package br.com.nomadit.order.mapper;

import br.com.nomadit.order.dto.OrderResponse;
import br.com.nomadit.order.entity.Order;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-26T01:27:01-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toResponse(Order entity) {

        OrderResponse orderResponse = new OrderResponse();

        if ( entity != null ) {
            orderResponse.setControlNumber( entity.getControlNumber() );
            orderResponse.setRegistrationDate( entity.getRegistrationDate() );
            orderResponse.setProductName( entity.getProductName() );
            orderResponse.setUnitPrice( entity.getUnitPrice() );
            orderResponse.setQuantity( entity.getQuantity() );
            orderResponse.setClientCode( entity.getClientCode() );
            orderResponse.setTotalOrder( entity.getTotalOrder() );
        }

        return orderResponse;
    }
}
