package com.raphael.order_service.dtos.request;

import com.raphael.order_service.models.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequestDTO {

    private List<Products> productsList;

}


