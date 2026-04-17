package com.raphael.order_service.dtos.response;

import com.raphael.order_service.models.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllOrdersDTO {

    private List<Orders> listOrders;


}
