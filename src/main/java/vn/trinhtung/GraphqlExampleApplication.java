package vn.trinhtung;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;
import vn.trinhtung.entity.Order;
import vn.trinhtung.entity.Role;
import vn.trinhtung.entity.User;
import vn.trinhtung.repository.OrderRepository;
import vn.trinhtung.repository.UserRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class GraphqlExampleApplication implements CommandLineRunner {
	private final UserRepository userRepository;
	private final OrderRepository orderRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		if (userRepository.count() == 0) {
			User admin = User.builder().username("admin").password(passwordEncoder.encode("12345"))
					.role(Role.ADMIN).build();

			User user = User.builder().username("user").password(passwordEncoder.encode("12345"))
					.role(Role.USER).build();

			userRepository.saveAll(Arrays.asList(admin, user));
		}

		if (orderRepository.count() == 0) {
			Order order1 = Order.builder().totalPrice(129_000).phoneNumber("111111111")
					.address("Hung Yen").user(User.builder().id(1).build()).build();
			Order order2 = Order.builder().totalPrice(29_000).phoneNumber("222222222")
					.address("Ha Noi").user(User.builder().id(1).build()).build();
			Order order3 = Order.builder().totalPrice(69_000).phoneNumber("333333333")
					.address("Ha Nam").user(User.builder().id(1).build()).build();
			Order order4 = Order.builder().totalPrice(59_000).phoneNumber("444444444")
					.address("Nam Dinh").user(User.builder().id(2).build()).build();
			Order order5 = Order.builder().totalPrice(519_000).phoneNumber("555555555")
					.address("Quang Ninh").user(User.builder().id(2).build()).build();
			Order order6 = Order.builder().totalPrice(299_000).phoneNumber("666666666")
					.address("Bac Giang").user(User.builder().id(2).build()).build();

			orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4, order5, order6));
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(GraphqlExampleApplication.class, args);
	}

}
