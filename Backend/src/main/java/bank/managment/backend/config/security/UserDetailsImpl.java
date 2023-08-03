package bank.managment.backend.config.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import bank.managment.backend.entities.Role;
import bank.managment.backend.entities.User;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String password;
	private String username;
	List<GrantedAuthority> authorities;
	public UserDetailsImpl(User user)
	{
		this.username=user.getLogin();
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true ;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}