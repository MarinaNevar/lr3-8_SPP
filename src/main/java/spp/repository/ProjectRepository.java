package spp.repository;

import spp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import spp.entity.Vacancy;

import java.util.List;

/**
 * Created by admin on 23.04.2017.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByOwnerId(Long id);

    Project findById(Long id);
}
