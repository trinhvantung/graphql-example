package vn.trinhtung.dto;

import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
	private String token;
	private Collection<SimpleGrantedAuthority> roles;
	private String username;
}
