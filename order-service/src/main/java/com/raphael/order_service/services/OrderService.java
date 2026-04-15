package com.raphael.order_service.services;


import com.raphael.order_service.dtos.request.CreateOrderRequestDTO;
import com.raphael.order_service.dtos.response.CreateOrderResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final RabbitTemplate rabbitTemplate;

    public CreateOrderResponseDTO create(CreateOrderRequestDTO requestDTO) {

        //implementar Lógica pra persistir e salvar no banco de dados

        //Publish event in queue
        rabbitTemplate.convertAndSend("order.queue");

        return new CreateOrderResponseDTO("Pedido publicado na fila...");
    }

}
