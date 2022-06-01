package com.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	RestTemplate restTemplate;
	
	public void saveOrder(OrderVO order) {
		orderRepository.save(order);
		restTemplate.getForEntity("http://localhost:8081/email", String.class);
	}
	public List<OrderVO> getOrders() {
		return orderRepository.findAll();
	}

}