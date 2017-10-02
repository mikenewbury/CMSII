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
import uk.co.nit.cms.repository.security.GroupRepository;
import uk.co.nit.cms.repository.security.RoleRepository;

@Controller
public class GroupController {
	
	private static String EDITGROUP = "editgroup";
	private static String GROUPROLES = "grouproles";
		
	@InitBinder     /* Converts empty strings into null when a form is submitted */  
	  public void initBinder(WebDataBinder binder) {  
	      binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
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
	private GroupRepository groupRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@ModelAttribute
	public Group getGroup(){
		Group group = new Group();
		return group;
	}
	
	
	@RequestMapping("/groups")
	public String showGroups(Model model, Pageable pageable)	{
		
		long rows = groupRepository.count();
		long pages = rows/10;
		
		if (rows % 10 > 0) {
			pages ++;
		}
		model.addAttribute("pages", pages);
		model.addAttribute("page", groupRepository.findAll(pageable));
		return "groups";
		
	}
	
	@RequestMapping("/groups/new")
	public String newGroup(Model model)	{
		
		model.addAttribute("group" , getGroup());		
		return EDITGROUP;		
	}
	

	@RequestMapping("/groups/{groupId}")
	public String editGroup(@PathVariable("groupId") Long groupId, Model model)	{
		Group group = groupRepository.findOne(groupId);
		model.addAttribute("group" , group);		
		return EDITGROUP;		
	}

	
	// TODO this should do a redirect at the end but that then loses the message. Maybe try adding it as a request param on the url
	@RequestMapping(value="/groups/save", method=RequestMethod.POST)
	public String saveGroup(@Valid Group group, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {			
            return EDITGROUP;
        }
		
		model.addAttribute("message" , "Group saved successfully");
		groupRepository.save(group);
		return EDITGROUP;
	}
	
	@RequestMapping(value="/grouproles/{groupId}", method=RequestMethod.GET)
	public String assignGroupRoles(@PathVariable("groupId") Long groupId, Model model) {
		
		Group group = groupRepository.findOne(groupId);
		 
		List<Role> availableRoles = roleRepository.findAll();		
		
		model.addAttribute("group", group);
		
		model.addAttribute("availableRoles", availableRoles);
		
		return GROUPROLES;
	}
	
	@RequestMapping(value="/grouproles", method=RequestMethod.POST)
	public String saveGroupRoles(@ModelAttribute Group group){
		
		Group groupToSave = groupRepository.findOne(group.getId());
		groupToSave.setRoles(group.getRoles());
		groupRepository.save(groupToSave);		
		return "redirect:/groups/" + group.getId();
	}
	
}
