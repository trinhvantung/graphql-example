package vn.trinhtung.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import vn.trinhtung.entity.Order;
import vn.trinhtung.repository.OrderRepository;

@Component
public class OrderQueryResolver implements GraphQLQueryResolver {
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAllOrderByUser(Integer userId) {
		return orderRepository.findAllByUserId(userId);
	}

	public List<Order> findAllOrder() {
		return orderRepository.findAll();
	}
}
