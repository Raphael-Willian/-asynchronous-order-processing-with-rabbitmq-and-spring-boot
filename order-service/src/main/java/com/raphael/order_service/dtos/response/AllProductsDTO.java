package com.raphael.order_service.dtos.response;

import com.raphael.order_service.models.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AllProductsDTO {

    private List<Products> productsList;

}
