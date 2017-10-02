/**
 * 
 */
package uk.co.nit.cms.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.co.nit.cms.entity.security.Group;
import uk.co.nit.cms.entity.security.Role;

/**
 * @author Mike
 *
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
