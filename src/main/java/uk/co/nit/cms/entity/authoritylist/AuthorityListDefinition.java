package uk.co.nit.cms.entity.authoritylist;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uk.co.nit.cms.entity.BaseEntity;

@Entity
@Table(name="AUTHORITY_LIST_DEFINITION")
public class AuthorityListDefinition extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private Long id;
	
	@Column(unique=true)
	private String name;
	
	@Column
	private boolean system;
	
	@Column
	private String definition;
	
	@Column
	private String note;

	@OneToMany(mappedBy="authorityListDefinition", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<AuthorityListValue> values;
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
	 * @return the system
	 */
	public boolean isSystem() {
		return system;
	}

	/**
	 * @param system the system to set
	 */
	public void setSystem(boolean system) {
		this.system = system;
	}

	/**
	 * @return the definition
	 */
	public String getDefinition() {
		return definition;
	}

	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the values
	 */
	public List<AuthorityListValue> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(List<AuthorityListValue> values) {
		this.values = values;
	}
	
	public void addValue(AuthorityListValue value) {
		if (values == null) {
			values = new ArrayList<AuthorityListValue>();
		}
		values.add(value);
	}
	
}
