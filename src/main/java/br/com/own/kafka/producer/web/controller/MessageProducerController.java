package br.com.own.kafka.producer.web.controller;


import br.com.own.kafka.producer.domain.business.KafkaSender;
import br.com.own.kafka.producer.web.view.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/kafka")
public class MessageProducerController {

    private KafkaSender kafkaSender;

    @Autowired
    public MessageProducerController(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @PostMapping(value = "/producer")
    public ResponseEntity send(@RequestBody Message message ) {
        this.kafkaSender.send( message.getTopic() , message.getText() );

        return ResponseEntity.created(URI.create("")).body(message);
    }

}
