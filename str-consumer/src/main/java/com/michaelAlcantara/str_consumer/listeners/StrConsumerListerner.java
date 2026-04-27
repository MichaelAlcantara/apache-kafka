package com.michaelAlcantara.str_consumer.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.michaelAlcantara.str_consumer.custom.StrConsumerCustomListener;

@Component
public class StrConsumerListerner {
	
    private static final Logger log = LogManager.getLogger(StrConsumerListerner.class);	

	@StrConsumerCustomListener(groupId = "group-1")
	public void create(String message) {
		log.info("CREATE ::: Receive message {}", message);
	}
	
	@StrConsumerCustomListener(groupId = "group-1")
	public void log(String message) {
		log.info("LOG ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-2", containerFactory = "validMessageContainerFactory", topics = "str-topic")
	public void groupTwo(String message) {
		log.info("groupTwo ::: Receive message {}", message);
	}

}
