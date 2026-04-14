package com.raphael.asyncorderprocessing.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    private static  final String QUEUE = "order.queue";


    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true); //Boolean como true indicando a durabilidade da fila
    }

}
