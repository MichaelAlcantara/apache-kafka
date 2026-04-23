package com.michaelAlcantara.str_consumer.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StrConsumerListerner {
	
    private static final Logger log = LogManager.getLogger(StrConsumerListerner.class);	

	@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
	public void create(String message) {
		log.info("CREATE ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
	public void log(String message) {
		log.info("LOG ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
	public void groupTwo(String message) {
		log.info("groupTwo ::: Receive message {}", message);
	}

}
