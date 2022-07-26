package vn.trinhtung.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import vn.trinhtung.entity.User;
import vn.trinhtung.repository.UserRepository;

@Component
public class UserQueryResolver implements GraphQLQueryResolver {
	@Autowired
	private UserRepository repo;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> findAllUser() {
		return repo.findAll();
	}
}
