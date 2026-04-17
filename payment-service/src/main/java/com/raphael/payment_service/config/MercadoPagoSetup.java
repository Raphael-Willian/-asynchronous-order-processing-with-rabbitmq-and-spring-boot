package com.raphael.payment_service.config;

import com.mercadopago.MercadoPagoConfig;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MercadoPagoSetup {

    private static final Logger log = LoggerFactory.getLogger(MercadoPagoSetup.class);

    @Value("${mercadopago.access-token}")
    private String ACCESS_TOKEN;

    @PostConstruct
    public void init() {
        if(ACCESS_TOKEN == null || ACCESS_TOKEN.isBlank()) {
            log.error("Mercado Pago Access Token não configurado! Verifique as variáveis de ambiente.");
            throw new IllegalArgumentException("Mercado pago access token é obrigatório.");
        }
        MercadoPagoConfig.setAccessToken(ACCESS_TOKEN);
        log.info("SDK do Mercado Pago inicializado com sucesso.");
    }


}
