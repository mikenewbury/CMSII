package uk.co.nit.cms;

import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.core.GrantedAuthority;

import uk.co.nit.cms.configuration.DomainConfiguration;
import uk.co.nit.cms.entity.security.Group;
import uk.co.nit.cms.entity.security.Role;
import uk.co.nit.cms.entity.security.User;
import uk.co.nit.cms.repository.security.GroupRepository;
import uk.co.nit.cms.repository.security.RoleRepository;
import uk.co.nit.cms.repository.security.UserRepository;

public class Application {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DomainConfiguration.class)) {

			RoleRepository roleRepo = context.getBean(RoleRepository.class);
			GroupRepository groupRepo = context.getBean(GroupRepository.class);
			UserRepository userRepo = context.getBean(UserRepository.class);

			List<Role> roles = roleRepo.findAll();
			List<Group> groups = groupRepo.findAll();
			List<User> users = userRepo.findAll();

			System.out.println("\n\n*************************************************");
			for (Role role : roles) {
				System.out.println(role);
				for (Group group : role.getGroups()) {
					System.out.println("\t" + group);
				}
			}

			for (Group group : groups) {
				System.out.println(group);
			}

			for (User user : users) {
				System.out.println(user);
				Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
				for (GrantedAuthority authority : authorities){
					System.out.println("\t\tauth = " + authority);
				}
					
			}
			System.out.println("*************************************************\n\n");
		}
	}
}
