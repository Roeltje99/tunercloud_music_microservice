package com.tunercloud.music.rabbitmq;

import com.tunercloud.music.models.Artist;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitSender {
    /*
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange exchange;

    public void sendUpdate(ArtistWrapper artist)
    {
        rabbitTemplate.convertAndSend(exchange.getName(),"update", artist);
        System.out.println(" [x] Sent '" + artist.toString() + " to update");
    }

    public void sendDelete(ArtistWrapper artist)
    {
        rabbitTemplate.convertAndSend(exchange.getName(),"delete", artist);
        System.out.println(" [x] Sent '" + artist.toString() + "' to delete");
    }

    public void sendAdd(ArtistWrapper artist)
    {
        rabbitTemplate.convertAndSend(exchange.getName(),"add", artist);
        System.out.println(" [x] Sent '" + artist.toString() + "' to add");
    }
     */
}
