package com.paradigma0621.core.messaging.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClockingListener {

    // IMPORTANT: ASSURE TO CREATE THE "clockings-registers" QUEUE IN RABBITMQ BEFORE START MICROSERVICE
    @RabbitListener(queues = "${mq.queues.clockings-registers-queue}")
    public void receberSolicitacaoEmissao(@Payload String payload){
            log.info("Message from RabbitMQ: {} ", payload);
    }
}
