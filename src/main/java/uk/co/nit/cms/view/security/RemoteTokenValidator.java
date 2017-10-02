package uk.co.nit.cms.view.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import uk.co.nit.cms.entity.security.User;
import uk.co.nit.cms.repository.security.UserRepository;

@Component
public class RemoteTokenValidator {

	@Autowired
	private UserRepository repo;
	
	@SuppressWarnings("deprecation")	
	public String validate(String token) throws IOException, ServletException {
		
		System.out.println("Validating token: " + token);
		String username = null;
		
		String host = "ESDCH-WKCMSDEV1";
		int port = 80;
		String protocol = "http";

		DefaultHttpClient client = new DefaultHttpClient();
		
		try {
			HttpHost httpHost = new HttpHost(host, port, protocol);
			client.getParams().setParameter(ClientPNames.DEFAULT_HOST, httpHost);

			HttpGet securedResource = new HttpGet("/cms/GetAuthenticationToken?token=" + token);
			HttpResponse httpResponse = client.execute(securedResource);
			HttpEntity responseEntity = httpResponse.getEntity();
			username = EntityUtils.toString(responseEntity);			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (username == null || username.length() == 0)
		{
			System.out.println("Invalid token - redirecting to login page");
		}
		else {
			System.out.println("Token validated - username = " + username);
		}
		
		return username;
	}
	
}
