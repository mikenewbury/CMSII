/**
 * 
 */
package uk.co.nit.cms.repository.authoritylist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uk.co.nit.cms.entity.authoritylist.TermAvailability;

/**
 * @author Mike
 *
 */
@Repository
public interface TermAvailabilityRepository extends JpaRepository<TermAvailability, Long> {

}
