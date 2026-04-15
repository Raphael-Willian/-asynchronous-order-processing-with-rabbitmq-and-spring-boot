package com.raphael.order_service.controllers;

import com.raphael.order_service.dtos.request.CreateOrderRequestDTO;
import com.raphael.order_service.dtos.response.CreateOrderResponseDTO;
import com.raphael.order_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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





}
