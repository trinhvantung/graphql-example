package vn.trinhtung.resolver;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;
import vn.trinhtung.dto.OrderInput;
import vn.trinhtung.entity.Order;
import vn.trinhtung.entity.User;
import vn.trinhtung.repository.OrderRepository;

@Component
public class OrderMutationResolver implements GraphQLMutationResolver {
	@Autowired
	private OrderRepository orderRepository;

	public Order createOrder(Integer totalPrice, String phoneNumber, String address) {

		Order order = Order.builder().totalPrice(totalPrice).phoneNumber(phoneNumber)
				.address(address).user(User.builder().id(new Random().nextInt(1, 3)).build())
				.build();

		return orderRepository.save(order);
	}

	public Order createOrder(@Valid OrderInput order) {
		System.out.println(order.toString());
		return orderRepository.save(Order.builder().totalPrice(order.getTotalPrice())
				.phoneNumber(order.getPhoneNumber()).address(order.getAddress())
				.user(User.builder().id(new Random().nextInt(1, 3)).build()).build());
	}
}
