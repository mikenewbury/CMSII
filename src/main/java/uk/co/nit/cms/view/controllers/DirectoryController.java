package uk.co.nit.cms.view.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.co.nit.cms.entity.security.Group;
import uk.co.nit.cms.entity.security.Role;
import uk.co.nit.cms.entity.security.User;
import uk.co.nit.cms.repository.security.GroupRepository;
import uk.co.nit.cms.repository.security.RoleRepository;
import uk.co.nit.cms.repository.security.UserRepository;

@Controller
public class DirectoryController {
	
	@Autowired 
	private UserRepository repo;
	
	@RequestMapping("/locations")
	public String locationsRedirect(HttpServletRequest request, HttpServletResponse response, Model model, Authentication authentication)	{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				
		Cookie cookie = new Cookie ("JSESSIONID",user.getSessionId());
		cookie.setDomain("localhost");
		cookie.setPath("/");
		cookie.setComment("Session on old cms");
		response.addCookie(cookie);
		
		return "redirect:http://esdch-wkcmsdev1/cms/mainWeb/MainHome.do?home.action=Locations";	
		
	}
	
	
}
