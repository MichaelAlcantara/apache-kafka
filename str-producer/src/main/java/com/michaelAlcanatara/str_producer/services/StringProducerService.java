package com.michaelAlcanatara.str_producer.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StringProducerService {

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    private static final Logger log = LogManager.getLogger(StringProducerService.class);

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message).addCallback(
                success -> {
                	if(success != null) {
                		log.info("Send message with success {}", message);
                		log.info("Partition {}, Offset {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
                	}
                },
                error -> log.error("Error send message")
        );
    }
}
