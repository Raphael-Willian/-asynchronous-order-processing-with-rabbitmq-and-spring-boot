package com.raphael.order_service.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderResponseDTO {

    //Return message with response for user/client for application
    private String message;

}
