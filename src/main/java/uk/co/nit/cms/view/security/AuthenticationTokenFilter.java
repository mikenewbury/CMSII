package uk.co.nit.cms.view.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import uk.co.nit.cms.entity.security.User;
import uk.co.nit.cms.repository.security.UserRepository;

public class AuthenticationTokenFilter implements Filter {

	@Autowired 
	private RemoteTokenValidator tokenValidator;
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public void init(FilterConfig fc) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
		
		SecurityContext context = SecurityContextHolder.getContext();

		HttpServletRequest httpRequest = (HttpServletRequest) req;

		// System.out.println("Authenticating uri: " + httpRequest.getRequestURI());
			
		if (context.getAuthentication() != null && context.getAuthentication().isAuthenticated()) {
			// do nothing
		} else {
			String token = httpRequest.getParameter("Token");
			if (token != null)
			{
				String username = tokenValidator.validate(token);
				if (username != null) {
					User user = repo.findByName(username); 
					if (user != null) {
			            Authentication auth = new PreAuthenticatedAuthenticationToken(user, token,user.getAuthorities());
			            auth.setAuthenticated(true);
			            SecurityContextHolder.getContext().setAuthentication(auth);
					} 
				}
			}
		}

		fc.doFilter(req, res);
	}

	@Override
	public void destroy() {

	}

}
