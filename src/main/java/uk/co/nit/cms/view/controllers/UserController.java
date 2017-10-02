package uk.co.nit.cms.view.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Pageable;
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
public class UserController {
	
	private static String EDITUSER = "edituser2";
	private static String USERGROUPS = "usergroups";
	private static String USERROLES = "userroles";
	
	@InitBinder     /* Converts empty strings into null when a form is submitted */  
	  public void initBinder(WebDataBinder binder) {  
	      binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	      binder.registerCustomEditor(Set.class,"groups", new CustomCollectionEditor(Set.class){
	            protected Object convertElement(Object element){
	                if (element instanceof String) {
	                    Group group = groupRepository.findOne(Long.parseLong(element.toString()));

	                    return group;
	                }
	                return null;
	            }
	        });
	      binder.registerCustomEditor(Set.class,"roles", new CustomCollectionEditor(Set.class){
	            protected Object convertElement(Object element){
	                if (element instanceof String) {
	                    Role role = roleRepository.findOne(Long.parseLong(element.toString()));

	                    return role;
	                }
	                return null;
	            }
	        });

	}
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@ModelAttribute
	public User getUser(){
		User user = new User();
		user.setEnabled(true);
		user.setLocked(false);		
		return user;
	}
	
	
	@RequestMapping("/users")
	public String showUsers(Model model, Pageable pageable)	{
		
		long rows = userRepository.count();
		long pages = rows/10;
		
		if (rows % 10 > 0) {
			pages ++;
		}
		model.addAttribute("pages", pages);
		model.addAttribute("page", userRepository.findAll(pageable));
		return "users";
		
	}
	
	@RequestMapping("/users/new")
	public String newUser(Model model)	{
		
		model.addAttribute("user" , getUser());		
		return EDITUSER;		
	}
	

	@RequestMapping("/users/{userId}")
	public String editUser(@PathVariable("userId") Long userId, Model model)	{
		User user = userRepository.findOne(userId);
		model.addAttribute("user" , user);		
		return EDITUSER;		
	}

	
	// TODO this should do a redirect at the end but that then loses the message. Maybe try adding it as a request param on the url
	@RequestMapping(value="/users/save", method=RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {			
            return EDITUSER;
        }
		
		model.addAttribute("message" , "User saved successfully");
		userRepository.save(user);
		return EDITUSER;
	}
	
	@RequestMapping(value="/usergroups/{userId}", method=RequestMethod.GET)
	public String assignUserGroups(@PathVariable("userId") Long userId, Model model) {
		
		User user = userRepository.findOne(userId);
		 
		List<Group> availableGroups = groupRepository.findAll();		
		
		model.addAttribute("user", user);
		
		model.addAttribute("availableGroups", availableGroups);
		
		return USERGROUPS;
	}
	
	@RequestMapping(value="/usergroups", method=RequestMethod.POST)
	public String saveUserGroups(@ModelAttribute User user){
		
		User userToSave = userRepository.findOne(user.getId());
		userToSave.setGroups(user.getGroups());
		userRepository.save(userToSave);		
		return "redirect:/users/" + user.getId();
	}
	
	@RequestMapping(value="/userroles/{userId}", method=RequestMethod.GET)
	public String assignUserRoless(@PathVariable("userId") Long userId, Model model) {
		
		User user = userRepository.findOne(userId);
		 
		List<Role> availableRoles = roleRepository.findAll();		
		
		model.addAttribute("user", user);
		
		model.addAttribute("availableRoles", availableRoles);
		
		return USERROLES;
	}
	
	@RequestMapping(value="/userroles", method=RequestMethod.POST)
	public String saveUserRoles(@ModelAttribute User user){
		
		User userToSave = userRepository.findOne(user.getId());
		userToSave.setRoles(user.getRoles());
		userRepository.save(userToSave);		
		return "redirect:/users/" + user.getId();
	}
	
	// this is really a dummy return to enable apache to redirect back to the old system. 
	@RequestMapping(value="/users/close", method=RequestMethod.GET)
	public String close(){
		return "redirect:/home?home.action=Admin";
	}
	
}
