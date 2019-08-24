package com.example.kafka.Kafka_Demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.Kafka_Demo.model.User;

@RestController
@RequestMapping("/rest/kafka")
public class KafkaPublisherController {

	@Autowired
	private KafkaTemplate<String, User> template;
	
	@GetMapping(value="/publish/{name}")
	public String publishMessage(@PathVariable("name") String name) {
		String topic = "kafka_example";
		User user = new User();
		user.setName(name);
		user.setAddress("bill board 32");
		user.setAge(22);
		template.send(topic,user);
		return name;
	}
	
}
