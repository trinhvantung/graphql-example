package vn.trinhtung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.trinhtung.config.AppUserDetails;
import vn.trinhtung.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new AppUserDetails(repo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found")));
	}

}
