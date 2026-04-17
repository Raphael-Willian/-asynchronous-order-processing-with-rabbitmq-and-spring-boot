package com.raphael.order_service.dtos.response;

import com.raphael.order_service.models.Products;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private UUID idOrder;
    private List<Products> productsOrder;
    private BigDecimal totalValue;

}
