package vn.trinhtung.resolver;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLResolver;
import vn.trinhtung.entity.Order;
import vn.trinhtung.entity.User;

@Component
public class OrderResolver implements GraphQLResolver<Order> {
	public User user(Order order) {
		return order.getUser();
	}
}
