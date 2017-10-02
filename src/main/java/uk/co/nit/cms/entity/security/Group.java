package uk.co.nit.cms.entity.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="CMSGROUP")
public class Group {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;

	@ManyToMany(mappedBy = "groups" , fetch = FetchType.EAGER)	
	private Set<User> users;
	
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
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		if (roles == null){
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

	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
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
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", roles=" + roles + "]";
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
	
	public boolean isDeletable() {
		if(getUsers().size() > 0) {
			return false;
		}
		return true;
	}
	
}

