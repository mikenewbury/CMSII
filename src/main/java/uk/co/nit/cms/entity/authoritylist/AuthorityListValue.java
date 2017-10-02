package uk.co.nit.cms.entity.authoritylist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AUTHORITY_LIST_VALUE")
public class AuthorityListValue {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, unique = true, nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ALD_ID")
	private AuthorityListDefinition authorityListDefinition;
	
	@ManyToOne
	@JoinColumn(name="TS_ID", nullable = false)
	private TermStatus TermStatus;
	
	@ManyToOne	
	@JoinColumn(name="TA_ID", nullable = false)
	private TermAvailability TermAvailability;
	
	@Column(name="SYSTEM_VALUE")
	private String systemValue;
	
	@Column 
	private String code;
	
	@Column(name="DISPLAY_VALUE")
	private  String displayValue;
	
	@Column(name="SEQ")
	private Integer seq;

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
	 * @return the authorityListDefinition
	 */
	public AuthorityListDefinition getAuthorityListDefinition() {
		return authorityListDefinition;
	}

	/**
	 * @param authorityListDefinition the authorityListDefinition to set
	 */
	public void setAuthorityListDefinition(AuthorityListDefinition authorityListDefinition) {
		this.authorityListDefinition = authorityListDefinition;
	}

	
	/**
	 * @return the termStatus
	 */
	public TermStatus getTermStatus() {
		return TermStatus;
	}

	/**
	 * @param termStatus the termStatus to set
	 */
	public void setTermStatus(TermStatus termStatus) {
		TermStatus = termStatus;
	}

	/**
	 * @return the termAvailability
	 */
	public TermAvailability getTermAvailability() {
		return TermAvailability;
	}

	/**
	 * @param termAvailability the termAvailability to set
	 */
	public void setTermAvailability(TermAvailability termAvailability) {
		TermAvailability = termAvailability;
	}

	/**
	 * @return the systemValue
	 */
	public String getSystemValue() {
		return systemValue;
	}

	/**
	 * @param systemValue the systemValue to set
	 */
	public void setSystemValue(String systemValue) {
		this.systemValue = systemValue;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the displayValue
	 */
	public String getDisplayValue() {
		return displayValue;
	}

	/**
	 * @param displayValue the displayValue to set
	 */
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	/**
	 * @return the seq
	 */
	public Integer getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
}
