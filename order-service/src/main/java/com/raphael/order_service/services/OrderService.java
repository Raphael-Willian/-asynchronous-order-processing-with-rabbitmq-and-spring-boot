package com.raphael.order_service.services;


import com.raphael.order_service.dtos.request.CreateOrderRequestDTO;
import com.raphael.order_service.dtos.response.CreateOrderResponseDTO;
import com.raphael.order_service.models.Orders;
import com.raphael.order_service.repositorys.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final RabbitTemplate rabbitTemplate;
    private final OrdersRepository ordersRepository;

    public CreateOrderResponseDTO create(CreateOrderRequestDTO requestDTO) {

        //implementar Lógica pra persistir e salvar no banco de dados
        if(requestDTO.getItems().isEmpty()) {
            throw new RuntimeException("A requisição não contem dados válidos.");
        }
        Orders newOrder = new Orders();

        newOrder.setItemsOrder(requestDTO.getItems());

        BigDecimal sumOfValues = newOrder.getItemsOrder()
                .stream().map(item -> item.getValueOfItem()).reduce(BigDecimal.ZERO, BigDecimal::add);

        newOrder.setTotalValue(sumOfValues);

        ordersRepository.save(newOrder);

        //Publish event in queue
        rabbitTemplate.convertAndSend("order.queue", newOrder);

        return new CreateOrderResponseDTO("PEDIDO ID: " + newOrder.getIdOrder() + " publicado com sucesso");
    }

}
