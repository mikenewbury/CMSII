package uk.co.nit.cms.view.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import uk.co.nit.cms.entity.security.User;
import uk.co.nit.cms.repository.security.UserRepository;


@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository repo;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		User user = repo.findByName(token.getName()); 
		
		if(!user.getPassword().equalsIgnoreCase(token.getCredentials().toString())) {
			throw new BadCredentialsException("The credentials are invalid");			
		}
	
		return new UsernamePasswordAuthenticationToken(user, user.getPassword(),user.getAuthorities());		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}
