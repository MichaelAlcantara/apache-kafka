package com.michaelAlcantara.str_consumer.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StrConsumerListerner {
	
    private static final Logger log = LogManager.getLogger(StrConsumerListerner.class);	

	@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
	public void listener(String message) {
		log.info("Receive message {}", message);
	}

}
