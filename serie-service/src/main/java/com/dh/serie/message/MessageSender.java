package com.dh.serie.message;

import com.dh.serie.entity.Serie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MessageSender {

    private final RabbitTemplate rabbitTemplate;
    private final Queue catalogQueue;

    public void send(Serie serie) {
        log.info("[SEND MESSAGE TO " + this.catalogQueue.getName() + "] -> " + serie);
        this.rabbitTemplate.convertAndSend(this.catalogQueue.getName(), serie);
    }

}

