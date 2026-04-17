package com.raphael.order_service.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_ORDERS = "order.queue";
    public static final String QUEUE_PRODUCTS = "products.queue";


    @Bean
    public JacksonJsonMessageConverter messageConverter() {
     return new JacksonJsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue queueOrders() {
        return new Queue(QUEUE_ORDERS, true); //Boolean for definition durable of queue
    }

    @Bean
    public Queue queueProducts() {
        return new Queue(QUEUE_PRODUCTS, true);
    }


}
