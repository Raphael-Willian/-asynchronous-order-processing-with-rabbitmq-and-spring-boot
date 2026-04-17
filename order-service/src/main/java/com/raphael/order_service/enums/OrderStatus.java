package com.raphael.order_service.enums;

public enum OrderStatus {
    PENDING,   //Criado, aguardando ação do usuário
    PAID,      //Confirmado pelo Mercado Pago
    REJECTED,  //Pagamento negado
    CANCELED   //Tempo expirado ou cancelamento manual
}