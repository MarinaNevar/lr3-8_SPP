package spp.dao;

import spp.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 23.04.2017.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
