package vn.trinhtung.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import vn.trinhtung.config.AppUserDetails;
import vn.trinhtung.config.JwtProvider;
import vn.trinhtung.dto.LoginRequest;
import vn.trinhtung.dto.LoginResponse;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtProvider jwtProvider;

	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		log.info("Username: {}, Password: {}", request.getUsername(), request.getPassword());

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				request.getUsername(), request.getPassword());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(LoginResponse.builder().username(userDetails.getUsername())
				.token(jwtProvider.generateToken(userDetails.getUsername()))
				.roles((Collection<SimpleGrantedAuthority>) userDetails.getAuthorities()).build());
	}

	@GetMapping("/me")
	public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal AppUserDetails userDetails) {
		return ResponseEntity.ok(userDetails);
	}

}
