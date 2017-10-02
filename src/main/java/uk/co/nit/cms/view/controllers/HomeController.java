package uk.co.nit.cms.view.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.nit.cms.entity.security.User;
import uk.co.nit.cms.repository.security.UserRepository;
import uk.co.nit.cms.view.security.RemoteTokenValidator;

@Controller
public class HomeController {

	@Autowired
	private UserRepository repo;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String goHome(Model model) {		
		return "home";
	}

	@RequestMapping("/admin")
	public String goAdmin() {
		return "admin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String goLogin(Model model) {
		return "login";
	}
}
