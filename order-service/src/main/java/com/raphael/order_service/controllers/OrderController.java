package com.raphael.order_service.controllers;

import com.raphael.order_service.dtos.request.CreateOrderRequestDTO;
import com.raphael.order_service.dtos.response.AllOrdersDTO;
import com.raphael.order_service.dtos.response.CreateOrderResponseDTO;
import com.raphael.order_service.dtos.response.OrderDTO;
import com.raphael.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor //Inject dependency with constructor (lombok)
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<CreateOrderResponseDTO> createOrder(@RequestBody CreateOrderRequestDTO requestDTO) {
        CreateOrderResponseDTO response = orderService.create(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<AllOrdersDTO> listAllOrders() {
        AllOrdersDTO listOrders = orderService.listAll();
        return ResponseEntity.ok(listOrders);
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<OrderDTO> listOrderById(@PathVariable @RequestBody UUID idOrder) {
        OrderDTO response = orderService.listById(idOrder);
        return ResponseEntity.ok(response);
    }


}
