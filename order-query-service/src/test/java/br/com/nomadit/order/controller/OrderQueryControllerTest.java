package br.com.nomadit.order.controller;

import br.com.nomadit.order.OrderQueryServiceApplication;
import br.com.nomadit.order.dto.OrderResponse;
import br.com.nomadit.order.repository.filter.OrderFilterCriteria;
import br.com.nomadit.order.service.OrderQueryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = OrderQueryServiceApplication.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class OrderQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrderQueryService orderQueryService;

    @InjectMocks
    private OrderQueryController orderQueryController;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderQueryController).build();
    }

    @Test
    public void testGetOrders() throws Exception {
        // Mock do serviço
        OrderResponse mockOrderResponse = new OrderResponse();
        mockOrderResponse.setControlNumber("123456");
        // Supondo que a lista retornada pelo serviço está vazia
        when(orderQueryService.search(any(OrderFilterCriteria.class))).thenReturn(Collections.singletonList(mockOrderResponse));

        // Chamada à API com parâmetros de exemplo
        mockMvc.perform(MockMvcRequestBuilders.get("/orders/v1")
                        .param("controlNumber", "123456")
                        .param("registrationDate", "01/01/2024")) // Use o formato esperado para a data
                .andExpect(status().isOk());
        // Você pode adicionar mais verificações aqui se necessário
    }
}
