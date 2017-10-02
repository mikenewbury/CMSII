package uk.co.nit.cms.entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity implements Serializable {
	
	/** Default value included to remove warning. **/
    private static final long serialVersionUID = 1L;

    /**
     * The last modified date/time (intended for all user managed entities).
     */
    @Column(name = "modified_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    /**
     * The last modified by username (intended for all user managed entities).
     */
    @Column(name = "modified_by", nullable = false, length = 30)
    private String modifiedBy;

    /**
     * Gets the last modified date/time
     * 
     * @return the modifiedDate
     */
    public Date getModifiedDate()
    {
        return modifiedDate;
    }

    /**
     * Gets the last modified by username.
     * 
     * @return the modifiedBy
     */
    public String getModifiedBy()
    {
        return modifiedBy;
    }

    /**
     * Automatically stamps the two modified fields with values on create and update.
     */
    @PrePersist
    @PreUpdate
    private void stamp()
    {
        modifiedDate = new Date();
        modifiedBy = "TODO";
//        Principal principal = SecurityContextAssociation.getPrincipal();
//        modifiedBy = (principal == null ? SystemConstants.SYSUSER : principal.getName());
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modifiedBy == null) ? 0 : modifiedBy.hashCode());
        result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        BaseEntity other = (BaseEntity) obj;
        if (modifiedBy == null)
        {
            if (other.modifiedBy != null)
            {
                return false;
            }
        }
        else if (!modifiedBy.equals(other.modifiedBy))
        {
            return false;
        }
        if (modifiedDate == null)
        {
            if (other.modifiedDate != null)
            {
                return false;
            }
        }
        else if (!modifiedDate.equals(other.modifiedDate))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "BaseEntity [modifiedDate=" + DateFormat.getDateTimeInstance().format(modifiedDate) + ", modifiedBy=" + modifiedBy + "]";
    }

	
}
