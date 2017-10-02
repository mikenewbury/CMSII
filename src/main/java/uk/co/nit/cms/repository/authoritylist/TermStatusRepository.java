package uk.co.nit.cms.repository.authoritylist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uk.co.nit.cms.entity.authoritylist.TermStatus;

@Repository
public interface TermStatusRepository extends JpaRepository<TermStatus, Long> {

}
