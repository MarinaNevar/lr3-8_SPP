package spp.dao;

import spp.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 23.04.2017.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
