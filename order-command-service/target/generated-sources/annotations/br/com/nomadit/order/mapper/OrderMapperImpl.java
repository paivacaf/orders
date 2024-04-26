package br.com.nomadit.order.mapper;

import br.com.nomadit.order.dto.OrderRequest;
import br.com.nomadit.order.entity.Order;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-26T01:35:05-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toEntity(OrderRequest request) {

        Order.OrderBuilder order = Order.builder();

        if ( request != null ) {
            if ( request.getQuantity() != null ) {
                order.quantity( request.getQuantity() );
            }
            else {
                order.quantity( 0 );
            }
            order.controlNumber( request.getControlNumber() );
            order.registrationDate( request.getRegistrationDate() );
            order.productName( request.getProductName() );
            order.unitPrice( request.getUnitPrice() );
            order.clientCode( request.getClientCode() );
        }

        return order.build();
    }
}
