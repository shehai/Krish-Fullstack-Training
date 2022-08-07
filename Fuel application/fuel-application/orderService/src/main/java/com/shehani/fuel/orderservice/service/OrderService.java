package com.shehani.fuel.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shehani.fuel.orderservice.model.Order;
import com.shehani.fuel.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	KafkaTemplate<String,String> kafkaTemplate;
	
	@Value("${order.topic.name}")
	private String topicName;
	
	ObjectMapper om=new ObjectMapper();
	
	public Order submitOrder(Order order) {
		
		
		
		order.setStatus("CREATED");
		order = orderRepository.save(order);
		
		String message= null;
	    try {
	      message = om.writeValueAsString(order);
	    } catch (JsonProcessingException e) {
	      e.printStackTrace();
	    }
	    kafkaTemplate.send(topicName,message);
		
		//return orderRepository.findByFuelStationId(order.getFuelStationId());
		
		
		
		return order;
	}

}
