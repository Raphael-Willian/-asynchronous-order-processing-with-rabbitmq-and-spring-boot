package com.raphael.order_service.services;

import com.raphael.order_service.dtos.request.CreateProductRequestDTO;
import com.raphael.order_service.dtos.response.AllProductsDTO;
import com.raphael.order_service.dtos.response.CreateProductResponseDTO;
import com.raphael.order_service.dtos.response.ProductDTO;
import com.raphael.order_service.models.Products;
import com.raphael.order_service.repositorys.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.raphael.order_service.configs.RabbitMQConfig.QUEUE_PRODUCTS;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final RabbitTemplate rabbitTemplate;

    public CreateProductResponseDTO createProduct(CreateProductRequestDTO requestDTO) {

        if(requestDTO.getNameProduct().isEmpty()) {
            throw new RuntimeException("Erro: O nome do produto não foi informado");
        }

        Products newProduct = new Products();

        newProduct.setNameProduct(requestDTO.getNameProduct());
        newProduct.setDescription(requestDTO.getDescription());
        newProduct.setAmount(requestDTO.getAmount());
        newProduct.setPriceOfProduct(requestDTO.getPriceOfProduct());

        productsRepository.save(newProduct);

        rabbitTemplate.convertAndSend(QUEUE_PRODUCTS, newProduct); //impllementation feature in path publisher in after moment

        return new CreateProductResponseDTO("Produto criado com sucesso: " + newProduct.getNameProduct()
                + " | " + newProduct.getDescription() + " | " + newProduct.getDescription());


    }

    public AllProductsDTO listAll() {

        List<Products> listProducts = productsRepository.findAll();

        return new AllProductsDTO(listProducts);

    }

    public ProductDTO listById(UUID idProduct) {

        Products product = productsRepository.findById(idProduct)
                .orElseThrow(() -> new RuntimeException("O produto correspondente ao ID: " + idProduct + " não foi encontrado."));

        return new ProductDTO(product);


    }


}
