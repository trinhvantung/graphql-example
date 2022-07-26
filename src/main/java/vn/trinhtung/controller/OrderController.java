package vn.trinhtung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.trinhtung.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping
	public ResponseEntity<?> getAllOrder() {
		return ResponseEntity.ok(orderRepository.findAll());
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<?> getAllOrderByUser(@PathVariable Integer userId) {
		return ResponseEntity.ok(orderRepository.findAllByUserId(userId));
	}
}
