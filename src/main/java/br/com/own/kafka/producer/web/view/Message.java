package br.com.own.kafka.producer.web.view;

import lombok.Data;

@Data
public class Message {

    private String topic;
    private String text;

}
