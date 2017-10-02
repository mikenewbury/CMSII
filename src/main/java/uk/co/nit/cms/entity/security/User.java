package uk.co.nit.cms.entity.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="CMSUSER")
public class User implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private Long id;
	
	@NotNull
	@Size(min=2, max=50)
	@Column(unique=true, length = 50)
	private String name;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;

	@NotNull
	@Size(min=2, max=50)
	@Column(name = "real_name", length = 50, nullable = false)
	private String realName;

	@NotNull
	@Size(min=2, max=50)
	@Email
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "locked")
	private boolean locked;
		
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Group> groups;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
	
	
	private String sessionId;
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}


	/**
	 * @param locked the locked to set
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	/**
	 * @return the groups
	 */
	public Set<Group> getGroups() {
		if(groups==null) {
			groups = new HashSet<Group>();					
		}
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		if(roles==null){
			roles = new HashSet<Role>();
		}			
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<String> rolesAsStrings = new HashSet<String>();		
		
		for (Group group : groups){
			for (Role role : group.getRoles()){
				rolesAsStrings.add(role.getName());				
			}				
		}
		
		for (Role role : roles) {
			rolesAsStrings.add(role.getName());			
		}
		
		StringBuilder builder = new StringBuilder();
		
		int roleCount = 0;
		for (String role : rolesAsStrings){
			builder.append("ROLE_");
			builder.append(role);
			if (roleCount < rolesAsStrings.size()) {
				builder.append(",");
				roleCount++;
			}
		}
			
		return AuthorityUtils.commaSeparatedStringToAuthorityList(builder.toString());	
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", realName=" + realName + ", email="
				+ email + ", enabled=" + enabled + ", locked=" + locked + ", groups=" + groups + ", roles=" + roles
				+ "]";
	}

	public String getGroupsAsString() {		
		StringBuilder groupsSB = new StringBuilder();
		String groupsString = null;
		
		for (Group group : getGroups()){
			groupsSB.append(group.getName());
			groupsSB.append(", ");	
		}		
		
		groupsString = groupsSB.toString();
		if (groupsString.endsWith(", ")) {
			groupsString = groupsString.substring(0, groupsString.length()-2);
		}
		
		return groupsString;
	}
	
	public String getRolesAsString() {		
		StringBuilder rolesSB = new StringBuilder();
		String rolessString = null;
		
		for (Role role : getRoles()){
			rolesSB.append(role.getName());
			rolesSB.append(", ");	
		}		
		
		rolessString = rolesSB.toString();
		if (rolessString.endsWith(", ")) {
			rolessString = rolessString.substring(0, rolessString.length()-2);
		}
		
		return rolessString;
	}
	
}
