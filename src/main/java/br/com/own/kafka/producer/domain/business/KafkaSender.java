package br.com.own.kafka.producer.domain.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {

    private static final Logger LOGGER = LoggerFactory.getLogger( KafkaSender.class );

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String message) {
        LOGGER.info(" Sending topic | message: {} ", topic, message);

        this.kafkaTemplate.send(topic, message);
    }

}
