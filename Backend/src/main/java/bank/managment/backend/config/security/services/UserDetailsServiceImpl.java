package bank.managment.backend.config.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bank.managment.backend.config.security.UserDetailsImpl;
import bank.managment.backend.entities.User;
import bank.managment.backend.services.IUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userService.findByLogin(username);
		if(userOptional.isPresent()) {
		
				return new UserDetailsImpl(userOptional.get());
			
		}
		return null;
	}

}