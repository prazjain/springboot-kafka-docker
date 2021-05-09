package com.prash.springbootkafkadocker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private Producer producer;

    @PostMapping("/publish")
    public void messageToTopic(@RequestParam("message") final String message) {
        this.producer.sendMessage(message);
    }
}
