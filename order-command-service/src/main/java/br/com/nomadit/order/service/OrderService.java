package br.com.nomadit.order.service;

import br.com.nomadit.order.dto.OrderErrorResponse;
import br.com.nomadit.order.dto.OrderRequest;
import br.com.nomadit.order.dto.OrderResponse;
import br.com.nomadit.order.entity.Customer;
import br.com.nomadit.order.entity.Order;
import br.com.nomadit.order.exceptions.MaxOrderLimitExceededException;
import br.com.nomadit.order.exceptions.OrderProcessingException;
import br.com.nomadit.order.mapper.OrderMapper;
import br.com.nomadit.order.repository.CustomerRepository;
import br.com.nomadit.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private Set<String> controlNumberSet = new HashSet<>(); // Conjunto para rastrear números de controle únicos

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderMapper orderMapper;

    public List<OrderResponse> processOrders(List<OrderRequest> orders) {

        controlNumberSet = new HashSet<>();

        if (orders.size() > 10) {
            throw new MaxOrderLimitExceededException("O número de pedidos excede o limite permitido de 10.");
        }

        List<OrderResponse> responses = orders.stream()
                .map(orderMapper::toEntity)
                .map(this::processOrder)
                .collect(Collectors.toList());

        // Verificar se há algum pedido com erro
        boolean hasError = responses.stream()
                .anyMatch(OrderResponse::isError);

        if (hasError) {
            throw new OrderProcessingException(OrderErrorResponse
                    .builder()
                    .responses(responses.stream()
                                    .filter(OrderResponse::isError)
                                .collect(Collectors.toList()))
                    .build());
        }

        return responses;
    }

    private OrderResponse processOrder(Order order) {

        // Verificar se o número de controle já existe no banco de dados
        Optional<Order> existingPedido = orderRepository.findByControlNumber(order.getControlNumber());
        if (existingPedido.isPresent()) {
            return OrderResponse.builder()
                        .message("Erro: Número de controle já cadastrado" )
                        .error(true)
                        .controlNumber(order.getControlNumber())
                    .build();
        }

        // Verificar se o número de controle já foi cadastrado
        if (controlNumberSet.contains(order.getControlNumber())) {
            return OrderResponse.builder()
                    .message("Erro: Número de controle já cadastrado")
                    .error(true)
                    .controlNumber(order.getControlNumber())
                    .build();
        }

        // Verificar se o cliente com o clientCode fornecido existe
        Optional<Customer> existingClient = customerRepository.findByClientCode(order.getClientCode());
        if (!existingClient.isPresent()) {
            return OrderResponse.builder()
                    .message("Erro: Cliente não encontrado")
                    .error(true)
                    .controlNumber(order.getControlNumber())
                    .build();
        }

        // Adicionar o número de controle ao conjunto
        controlNumberSet.add(order.getControlNumber());

        // Definir a data de cadastro como a data atual, se não for fornecida
        if (order.getRegistrationDate() == null) {
            order.setRegistrationDate(LocalDate.now());
        }

        // Definir a quantidade como 1, se não for fornecida
        if (order.getQuantity() == 0) {
            order.setQuantity(1);
        }

        // Aplicar desconto com base na quantidade
        double discount = calculateDiscount(order.getQuantity());
        double total = order.getUnitPrice().doubleValue() * order.getQuantity() * (1 - discount);
        order.setTotalOrder(BigDecimal.valueOf(total));

        orderRepository.save(order);

        // Calcular e gravar o valor total do pedido
        // (Você pode adicionar a lógica de persistência de dados aqui)
        return OrderResponse.builder()
                .message("Pedido recebido e processado com sucesso.")
                .controlNumber(order.getControlNumber())
                .build();
    }

    private double calculateDiscount(int quantidade) {
        if (quantidade >= 10) {
            return 0.1; // 10% de desconto
        } else if (quantidade > 5) {
            return 0.05; // 5% de desconto
        } else {
            return 0;
        }
    }
}
