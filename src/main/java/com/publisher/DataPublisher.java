package com.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataPublisher {
    
	@Autowired
	private RabbitTemplate template;
	@PostMapping("/publish")
	public String publishMessage(@RequestBody Employee employee) {
		template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,employee);
		return "Message published";
	}
}
