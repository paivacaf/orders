package br.com.nomadit.order.controller;

import br.com.nomadit.order.dto.OrderResponse;
import br.com.nomadit.order.service.OrderQueryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(OrderQueryController.class)
class OrderQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrderQueryService orderQueryService;

    @InjectMocks
    private OrderQueryController orderQueryController;

    @Test
    void testGetOrders() throws Exception {
        // Mockando o serviço de consulta de pedidos para retornar uma lista de resposta de pedidos fictícia
        when(orderQueryService.search(any())).thenReturn(Collections.singletonList(new OrderResponse()));

        // Realizando a solicitação GET ao endpoint "/orders/v1" com parâmetros fictícios
        mockMvc.perform(MockMvcRequestBuilders.get("/orders/v1")
                .param("controlNumber", "12345")
                .param("registrationDate", "2024-04-26")
                .contentType(MediaType.APPLICATION_JSON))
                // Verificando se a resposta tem status 200 OK e se o conteúdo retornado é JSON
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }
}
