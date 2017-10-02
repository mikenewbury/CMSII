package uk.co.nit.cms.view.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import uk.co.nit.cms.entity.security.User;
import uk.co.nit.cms.repository.security.UserRepository;
/**
 * note that this class doesn't appear to get called from the preauth filter. 
 * @author newbury_md
 *
 */
public class TokenAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository repo;
	
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
    	System.out.println("In TokenAuthenticationProvider");
        if (auth.isAuthenticated())
            return auth;

        String token = auth.getName();
        User user = repo.findByName(token); 
		if (user != null) {
            auth = new PreAuthenticatedAuthenticationToken(user, token);
            auth.setAuthenticated(true);
            
		} else
            throw new BadCredentialsException("Invalid token " + token);
        return auth;
    }

	@Override
	public boolean supports(Class<?> authentication) {
		return PreAuthenticatedAuthenticationToken.class.equals(authentication);
	}
}
