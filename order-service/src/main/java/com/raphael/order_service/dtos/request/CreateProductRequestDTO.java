package com.raphael.order_service.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequestDTO {

    private String nameProduct;
    private String description;
    private int amount;
    private BigDecimal priceOfProduct;

}
