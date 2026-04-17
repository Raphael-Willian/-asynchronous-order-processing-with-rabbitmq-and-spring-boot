package com.raphael.order_service.services;


import com.raphael.order_service.dtos.request.CreateOrderRequestDTO;
import com.raphael.order_service.dtos.response.AllOrdersDTO;
import com.raphael.order_service.dtos.response.CreateOrderResponseDTO;
import com.raphael.order_service.dtos.response.OrderDTO;
import com.raphael.order_service.models.Orders;
import com.raphael.order_service.repositorys.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final RabbitTemplate rabbitTemplate;
    private final OrdersRepository ordersRepository;

    //Enable CacheEvict in after
    public CreateOrderResponseDTO create(CreateOrderRequestDTO requestDTO) {

        //implementar Lógica pra persistir e salvar no banco de dados
        if(requestDTO.getProductsList().isEmpty()) {
            throw new RuntimeException("A requisição não contem dados válidos.");
        }
        Orders newOrder = new Orders();

        newOrder.setProductsOrder(requestDTO.getProductsList());

        //Iteration on the list with sum of values/price of products. More multiply with amount of product
        BigDecimal sumOfValues = newOrder.getProductsOrder()
                .stream().map(item -> item.getPriceOfProduct()
                        .multiply(BigDecimal.valueOf(item.getAmount()))).reduce(BigDecimal.ZERO, BigDecimal::add);

        newOrder.setTotalValue(sumOfValues); //Set Total Value of Order

        ordersRepository.save(newOrder); //save new Order in database of application Order-Service

        //Publish event in queue, send new Order how param
        rabbitTemplate.convertAndSend("order.queue", newOrder);

        return new CreateOrderResponseDTO("PEDIDO ID: " + newOrder.getIdOrder() + " publicado com sucesso");
    }

    public AllOrdersDTO listAll() {

        List<Orders> orders = ordersRepository.findAll();

        return new AllOrdersDTO(orders);
    }

    public OrderDTO listById(UUID idOrder) {

        Orders order = ordersRepository.findById(idOrder)
                .orElseThrow(() -> new RuntimeException("Pedido com o ID informado não foi encontrado. " + "ID: " + idOrder));

       return new OrderDTO(order.getIdOrder(), order.getProductsOrder(), order.getTotalValue());

    }






}
