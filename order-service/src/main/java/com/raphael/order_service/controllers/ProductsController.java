package com.raphael.order_service.controllers;

import com.raphael.order_service.dtos.request.CreateProductRequestDTO;
import com.raphael.order_service.dtos.response.AllProductsDTO;
import com.raphael.order_service.dtos.response.CreateProductResponseDTO;
import com.raphael.order_service.dtos.response.ProductDTO;
import com.raphael.order_service.services.ProductsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductsController {

    private final ProductsService productsService;

    @PostMapping
    public ResponseEntity<CreateProductResponseDTO> create(@RequestBody CreateProductRequestDTO requestDTO) {
        CreateProductResponseDTO response = productsService.createProduct(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<AllProductsDTO> listAllProducts() {
        AllProductsDTO response = productsService.listAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{idProduct}")
    public ResponseEntity<ProductDTO> listProductById(@PathVariable @RequestBody UUID idProduct) {
        ProductDTO response = productsService.listById(idProduct);
        return ResponseEntity.ok(response);
    }

}
